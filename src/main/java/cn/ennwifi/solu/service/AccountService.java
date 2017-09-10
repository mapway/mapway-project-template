package cn.ennwifi.solu.service;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.random.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ennwifi.solu.api.module.Account;
import cn.ennwifi.solu.api.module.AccountInfoReq;
import cn.ennwifi.solu.api.module.AccountInfoResp;
import cn.ennwifi.solu.api.module.AccountLoginReq;
import cn.ennwifi.solu.api.module.AccountLoginResp;
import cn.ennwifi.solu.configure.UIProperties;
import cn.ennwifi.solu.configure.ldap.Person;
import cn.ennwifi.solu.tools.Times;
import cn.ennwifi.solu.ui.shared.repository.USERObj;



/**
 * 账户服务
 * 
 * @author zhangjianshe
 *
 */
@Service
public class AccountService {

  /**
   * 新奥账号
   */
  private final static String ACCOUNT_TYPE_ENN = "0";

  /**
   * 注册账号
   */
  private final static String ACCOUNT_TYPE_REG = "1";

  /**
   * 缺省的头像
   */
  private static final String DEFAULT_AVATOR = "/avator/user.png";

  @Autowired
  Dao dao;

  @Autowired
  LdapService ldapService;

  @Autowired
  UIProperties uiProperties;

  /**
   * 账户登录
   * 
   * @param req
   * @return
   */
  public AccountLoginResp accountLogin(AccountLoginReq req) {
    AccountLoginResp r = new AccountLoginResp();
    r.fail("开始操作");


    if (ACCOUNT_TYPE_ENN.equals(req.accountType)) {
      String accountHash = Lang.md5(req.userName + ACCOUNT_TYPE_ENN);
      USERObj account = findAccountByNameAndType(req.userName, ACCOUNT_TYPE_ENN);
      // 集团账号
      Person p = ldapService.authenticate(Person.class, req.userName, req.password);
      if (p == null) {
        r.fail("集团账号认证失败");
        return r;
      }
      // 认证成功

      if (account == null) {
        // 用户没有登陆过，需要插入数据库一条记录
        account = insertAccount(req, p, accountHash);
      } else {
        // 更新账户信息
        account = updateAccount(account, req, p);
      }
      // 检查是否禁止登陆
      if (account.getENABLED() != null && account.getENABLED() == 0) {
        r.fail("禁止登陆:" + account.getDISABLED_MSG());
        return r;
      }
      // 登录成功
      r.url = req.url;
      r.account = toAccount(account);
      r.ok();

    } else if (ACCOUNT_TYPE_REG.equals(req.accountType)) {
      String accountHash = Lang.md5(req.userName + ACCOUNT_TYPE_REG);
      USERObj account = findAccountByNameAndType(req.userName, ACCOUNT_TYPE_REG);
      // 注册账号
      if (account == null) {
        r.fail("此账号没有注册,请到 http://hy.ennwifi.cn/ 注册 或者用集团账号登录");
        return r;
      }
      if (!account.getPWD().equals(Lang.md5(req.password))) {
        r.fail("用户密码不正确");
        return r;
      }
      // 检查是否禁止登陆
      if (account.getENABLED() != null && account.getENABLED() == 0) {
        r.fail("禁止登陆:" + account.getDISABLED_MSG());
        return r;
      }
      account.setTOKEN(R.UU16());
      dao.update(account);
      // 登录成功
      r.url = req.url;
      r.account = toAccount(account);
      r.ok();
    } else {
      r.fail("不能识别账户类别:" + req.accountType);
    }
    return r;
  }

  private USERObj findAccountByNameAndType(String userName, String accountTypeEnn) {
    return dao.fetch(
        USERObj.class,
        Cnd.where(USERObj.FLD_NAME, "=", userName).and(USERObj.FLD_ACCOUNT_TYPE, "=",
            accountTypeEnn));
  }

  private Account toAccount(USERObj user) {
    Account account = new Account();
    account.accountType = user.getACCOUNT_TYPE().toString();
    if (Strings.isBlank(user.getAVATOR())) {
      user.setAVATOR(DEFAULT_AVATOR);
    }
    account.avator = uiProperties.getImagePrefix() + user.getAVATOR();
    account.email = user.getEMAIL();
    account.phone = user.getMOBILE();
    account.uid = user.getID();
    account.realName = user.getREAL_NAME();
    account.userName = user.getNAME();
    account.token = user.getTOKEN();
    // account.company = user.getCOMPANY();
    // account.contact = user.getCONTACTS();
    // account.office = user.getPOSITION();
    // account.department = user.getDEPARTMENT();
    account.userType = user.getUSER_TYPE();

    if ("010102".equals(user.getUSER_TYPE())) {
      // 企业用户
      // S_ENTERPRISEObj enterprise = dao.fetch(S_ENTERPRISEObj.class, user.getID().longValue());
      // if (enterprise == null) {
      // account.identity = "";
      // } else {
      // account.identity = enterprise.getINDUSTRY();
      // }
    } else {
      account.identity = user.getUSER_IDENTITIES();
    }
    return account;
  }

  private USERObj updateAccount(USERObj account, AccountLoginReq req, Person p) {
    account.setEMAIL(p.mail);
    account.setMOBILE(p.mobile);
    account.setTOKEN(R.UU16());
    dao.update(account);
    return account;
  }

  /**
   * @param req
   * @param p
   * @param accountHash
   * @return
   */
  private USERObj insertAccount(AccountLoginReq req, Person p, String accountHash) {
    USERObj account;
    account = new USERObj();
    account.setHASH(accountHash);
    account.setACCOUNT_TYPE(ACCOUNT_TYPE_ENN);
    account.setAVATOR("");
    account.setEMAIL(p.mail);
    account.setENABLED(1);
    account.setGENDER("030203");// 未知
    account.setLAST_TIME(Times.now());
    account.setNAME(req.userName);
    account.setREAL_NAME(p.cn);
    account.setMOBILE(p.mobile);
    account.setRECOMMEND_CODE("");
    account.setPWD("");
    account.setCREATE_TIME(Times.now());
    account.setUSER_IDENTITIES("");
    account.setTOKEN(R.UU16());
    account.setUSER_TYPE("010101");// 个人用户
    dao.insert(account);
    return account;
  }



  public AccountInfoResp accountInfo(AccountInfoReq req) {
    AccountInfoResp r = new AccountInfoResp();
    USERObj user = dao.fetch(USERObj.class, Cnd.where(USERObj.FLD_TOKEN, "=", req.token));
    if (user == null) {
      r.fail("无效TOKEN");
      return r;
    }
    r.ok();
    r.account = toAccount(user);
    return r;
  }

}
