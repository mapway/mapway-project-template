package cn.ennwifi.solu.service;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.OrderBy;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.util.cri.Static;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ennwifi.solu.configure.ldap.Person;
import cn.ennwifi.solu.tools.Times;
import cn.ennwifi.solu.ui.shared.module.AdminLoginResponse;
import cn.ennwifi.solu.ui.shared.module.DataFilter;
import cn.ennwifi.solu.ui.shared.module.LoginReqData;
import cn.ennwifi.solu.ui.shared.module.PagerData;
import cn.ennwifi.solu.ui.shared.module.RespData;
import cn.ennwifi.solu.ui.shared.module.SearchReq;
import cn.ennwifi.solu.ui.shared.module.ServerException;
import cn.ennwifi.solu.ui.shared.module.UserLoginType;
import cn.ennwifi.solu.ui.shared.module.UserReq;
import cn.ennwifi.solu.ui.shared.repository.METAObj;
import cn.ennwifi.solu.ui.shared.repository.RESOURCEObj;
import cn.ennwifi.solu.ui.shared.repository.USERObj;



/**
 * 管理后台登录.
 * 
 * @author zhangjianshe
 */
@Service
public class AdminService extends DataTableService {


  public static final String MODULE_CODE_SYSTEM = "030601";

  private static final String CURRENT_ADMIN = "CURRENT_ADMIN";


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
  public AdminLoginResponse login(LoginReqData req, HttpServletRequest request) {
    AdminLoginResponse resp = new AdminLoginResponse();
    USERObj user = new USERObj();

    if (req.type.equals(UserLoginType.USER_LOGIN_TYPE_LDAP)) {

      Person p = ldapService.authenticate(Person.class, req.username, req.password);
      if (p == null) {
        throw new RuntimeException("登录失败");
      }

      String hash = Lang.sha1(req.username + req.type);
      user = dao.fetch(USERObj.class, Cnd.where(USERObj.FLD_HASH, "=", hash));
      if (user == null) {
        long frontUserId = exportAdminUserToFrontUser(p, req.password);

      } else {
        if (user.getENABLED() == null || user.getENABLED() != 1) {
          user = null;
          request.getSession(true).setAttribute(CURRENT_ADMIN, null);
          throw new RuntimeException("用户被禁止登陆系统");
        }
      }
    } else if (req.type.equals(UserLoginType.USER_LOGIN_TYPE_REGISTER)) {
      String pwd = Lang.md5(req.password);
      Cnd where = Cnd.where(USERObj.FLD_NAME, "=", req.username);
      where = where.and(USERObj.FLD_PWD, "=", pwd);
      user = dao.fetch(USERObj.class, where);
    }

    if (user == null) {
      throw new RuntimeException("登录失败");
    } else {
      user.setUPDATE_TIME(Times.now());;
      user.setTOKEN(UUID.randomUUID().toString());
      dao.update(user, "^TOKEN|UPDATE_TIME$");
      request.getSession(true).setAttribute(CURRENT_ADMIN, user);
      resp.user = user;
    }

    return resp;
  }

  /**
   * 将后台用户转化为前台用户
   * 
   * @param p
   * @return
   */
  private long exportAdminUserToFrontUser(Person p, String pwd) {
    String userName = p.mobile;
    USERObj user = hasRegistered(userName);
    if (user == null) {
      user = new USERObj();
      user.setNAME(userName);
      user.setPWD(Lang.md5(pwd));
      user.setAVATOR("");
      user.setEMAIL(p.getMail());
      // todo 修改数据库内容
      user.setGENDER("0000");
      user.setENABLED(1);

      dao.insert(user);
    }
    return user.getID();
  }

  private USERObj hasRegistered(String userName) {
    return dao.fetch(USERObj.class, Cnd.where(USERObj.FLD_NAME, "=", userName));
  }

  /**
   * 根据TOKEN找到用户信息.
   *
   * @param token the token
   * @return the s USER obj
   */
  public USERObj findUserByToken(String token) {
    USERObj user = dao.fetch(USERObj.class, Cnd.where(USERObj.FLD_TOKEN, "=", token));
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
   * @param userId the userid
   * @return the list
   */
  public List<RESOURCEObj> userMainMenu(Long userId, Integer menuRootId) {


    String where =
        RESOURCEObj.FLD_ROOTID + " = " + menuRootId
            + " and id in (select res_id from admin_role_resource s"
            + " where s.role_id in (select role_id from admin_user_role where user_id=" + userId
            + ")) order by pid asc, rank asc";

    Condition cnd = Cnd.wrap(where);
    List<RESOURCEObj> authorities = dao.query(RESOURCEObj.class, cnd);

    return authorities;
  }

  public List<RESOURCEObj> userMenu(Long userId) {
    String where =
        RESOURCEObj.FLD_PID + "=1" + " and id in (select res_id from admin_role_resource s"
            + " where s.role_id in (select role_id from admin_user_role where user_id=" + userId
            + ")) order by pid asc,rank asc";

    Condition cnd = Cnd.wrap(where);
    List<RESOURCEObj> authorities = dao.query(RESOURCEObj.class, cnd);

    return authorities;
  }

  /**
   * 用户查找菜单的子菜单 <br/>
   * 查找方法: 用户->role->S_ATHOrity.
   *
   * @param userId the userid
   * @return the list
   */
  public List<RESOURCEObj> userSubMenu(Long userId, Integer menuId) {

    Cnd where = Cnd.where(RESOURCEObj.FLD_PID, "=", menuId);
    where.asc(RESOURCEObj.FLD_RANK);
    List<RESOURCEObj> authorities = dao.query(RESOURCEObj.class, where);
    return authorities;
  }


  /**
   * 用户对资源是否拥有权限
   * 
   * @param userId
   * @param resourceId
   * @return
   */
  public Boolean userOwnResource(Long userId, Long resourceId) {
    // 用户 角色 资源
    String strsql =
        "select count(rm.res_id) from admin_user_role ur,admin_role_resource rm where ur.role_id=rm.role_id and ur.user_id=@userId and rm.res_id=@resourceId";
    Sql sql = Sqls.create(strsql);
    sql.params().set("userId", userId).set("resourceId", resourceId);
    sql.setCallback(Sqls.callback.integer());
    dao.execute(sql);
    int count = sql.getInt(0);
    return count > 0;
  }

  /**
   * 直接查找子菜单
   * 
   * @param menuId
   * @return
   */
  public List<RESOURCEObj> subMenu(int menuId) {

    Cnd where = Cnd.where(RESOURCEObj.FLD_PID, "=", menuId);
    where.asc(RESOURCEObj.FLD_RANK);
    List<RESOURCEObj> resources = dao.query(RESOURCEObj.class, where);
    return resources;
  }

  public List<METAObj> fetchAllMetaData() {
    OrderBy where = Cnd.orderBy().asc(METAObj.FLD_PID).asc(METAObj.FLD_RANK);
    return dao.query(METAObj.class, where);
  }

  public Boolean deleteMetaData(Integer metaId) throws ServerException {
    Cnd where = Cnd.where(METAObj.FLD_PID, "=", metaId);
    int count = dao.count(METAObj.class, where);
    if (count > 0) {
      throw new ServerException("不能删除有子节点的节点");
    } else {
      dao.delete(METAObj.class, metaId);
    }
    return true;
  }

  public METAObj saveOrUpdateMetaData(final METAObj meta) throws ServerException {
    if (meta == null) {
      throw new ServerException("创建元数据提供空数据");
    }
    if (meta.getID() == null) {
      dao.insert(meta);
    } else {

      final METAObj old = dao.fetch(METAObj.class, meta.getID().intValue());

      // 需要更新所有子元素的CATALOG
      Trans.exec(new Atom() {

        @Override
        public void run() {

          if (!old.getNAME().equals(meta.getNAME())) {
            String catalogOld = old.getCATALOG() + "/" + old.getNAME();
            String catalogNew = old.getCATALOG() + "/" + meta.getNAME();

            String strsql =
                "update " + METAObj.TBL_META + " set " + METAObj.FLD_CATALOG + "=replace("
                    + METAObj.FLD_CATALOG + ",'" + catalogOld + "','" + catalogNew + "') where "
                    + METAObj.FLD_CATALOG + " like '" + catalogOld + "%'";
            Sql sql = Sqls.create(strsql);
            System.out.println(sql.toString());
            dao.execute(sql);
          }
          dao.update(meta);
        }
      });



    }
    return meta;
  }



  public USERObj sessionUser(HttpServletRequest threadLocalRequest) {

    return (USERObj) threadLocalRequest.getAttribute(CURRENT_ADMIN);
  }



  /**
   * 搜索用户
   * 
   * @param req
   * @return
   */
  public PagerData<USERObj> searchUserList(SearchReq req) {
    PagerData<USERObj> r = new PagerData<USERObj>();

    Pager pager = dao.createPager(req.getPageNumber(), req.getPageSize());
    Cnd where = Cnd.NEW();
    for (DataFilter df : req.filters) {
      where.and(df.name, df.op, df.value);
    }

    if (!Strings.isBlank(req.orderSql)) {
      where.and(new Static("1=1 order by " + req.orderSql));
    }
    r.setData(dao.query(USERObj.class, where, pager));
    r.setPage(req.getPageNumber());
    r.setPageCount(req.getPageSize());
    if (req.getCount() != null && req.getCount() > 0) {
      r.setTotal(req.getCount().intValue());
    } else {
      r.setTotal(dao.count(USERObj.class, where));
    }
    return r;
  }



}
