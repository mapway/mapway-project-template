package cn.ennwifi.solu.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ennwifi.solu.tools.Times;
import cn.ennwifi.solu.ui.shared.module.LoginReqData;
import cn.ennwifi.solu.ui.shared.module.LoginRespData;
import cn.ennwifi.solu.ui.shared.module.PagerData;
import cn.ennwifi.solu.ui.shared.module.RespData;
import cn.ennwifi.solu.ui.shared.module.UserLoginType;
import cn.ennwifi.solu.ui.shared.module.UserReq;
import cn.ennwifi.solu.ui.shared.repository.RESOURCEObj;
import cn.ennwifi.solu.ui.shared.repository.USERObj;

/**
 * 认证服务.
 * 
 * @author zhangjianshe
 */
@Service
public class AuthorityService {

  /** The dao. */
  @Autowired
  private Dao dao;


  @Autowired
  /** The authority service. */
  LdapService ldapService;


  /**
   * 用户登录过程.
   *
   * @param req the req
   * @param request the request
   * @return the login resp data
   */
  public LoginRespData login(LoginReqData req, HttpServletRequest request) {
    LoginRespData resp = new LoginRespData();
    USERObj user = new USERObj();

    if (req.type.equals(UserLoginType.USER_LOGIN_TYPE_LDAP)) {
      // 后台用户登录
      // 第一次登录 ，需要
    } else if (req.type.equals(UserLoginType.USER_LOGIN_TYPE_REGISTER)) {
      String pwd = Lang.md5(req.password);
      Cnd where = Cnd.where(USERObj.FLD_NAME, "=", req.username);
      where = where.and(USERObj.FLD_PWD, "=", pwd);
      user = dao.fetch(USERObj.class, where);
    }

    if (user == null) {
      resp.fail("登录失败");
    } else {
      user.setLAST_TIME(Times.now());;
      user.setTOKEN(UUID.randomUUID().toString());
      dao.update(user, "^TOKEN|LAST_TIME$");
      resp.user = user;
      resp.ok();
    }

    return resp;
  }

  /**
   * 根据TOKEN找到用户信息.
   *
   * @param token the token
   * @return the s USER obj
   */
  public USERObj findUserByToken(String token) {
    USERObj user = dao.fetch(USERObj.class, Cnd.where("TOKEN", "=", token));
    return user;
  }

  /**
   * 退出登录.
   *
   * @param request the request
   * @param req the req
   * @param response the response
   * @return the resp data
   */
  public RespData logout(HttpServletRequest request, UserReq req, HttpServletResponse response) {


    RespData resp = new RespData();
    response.addCookie(new Cookie("token", ""));
    resp.ok();
    return resp;
  }


  /**
   * 用户拥有的功能菜单,根据权限进行查找 <br/>
   * 查找方法: 用户->role->S_ATHOrity.
   *
   * @param long1 the userid
   * @return the list
   */
  public List<RESOURCEObj> userMainMenu(Long long1) {

    String where =
        "path like '/主菜单%' and id in (select authority_id from s_role_menu s"
            + " where s.role_id in (select role_id from s_user_role where user_id=" + long1
            + ")) order by rank asc";

    Condition cnd = Cnd.wrap(where);

    List<RESOURCEObj> authorities = dao.query(RESOURCEObj.class, cnd);
    System.out.println(Json.toJson(authorities));
    return authorities;
  }

  /**
   * User main menu.
   *
   * @param request the request
   * @return the pager data
   */
  public PagerData<RESOURCEObj> userMainMenu(USERObj user) {

    PagerData<RESOURCEObj> pageData = new PagerData<RESOURCEObj>();
    pageData.setData(userMainMenu(user.getID()));
    return pageData;
  }

}
