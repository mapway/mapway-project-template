package cn.ennwifi.solu.ui.shared.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.nutz.dao.Cnd;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.util.Daos;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import cn.ennwifi.solu.configure.UIProperties;
import cn.ennwifi.solu.service.AdminService;
import cn.ennwifi.solu.service.SpringService;
import cn.ennwifi.solu.tools.Actions;
import cn.ennwifi.solu.tools.CookieTools;
import cn.ennwifi.solu.tools.Resources;
import cn.ennwifi.solu.ui.client.rpc.IAdminService;
import cn.ennwifi.solu.ui.shared.module.AdminLoginResponse;
import cn.ennwifi.solu.ui.shared.module.LoginReqData;
import cn.ennwifi.solu.ui.shared.module.PagerData;
import cn.ennwifi.solu.ui.shared.module.SearchReq;
import cn.ennwifi.solu.ui.shared.module.ServerException;
import cn.ennwifi.solu.ui.shared.repository.APP_DATAObj;
import cn.ennwifi.solu.ui.shared.repository.METAObj;
import cn.ennwifi.solu.ui.shared.repository.RESOURCEObj;
import cn.ennwifi.solu.ui.shared.repository.ROLEObj;
import cn.ennwifi.solu.ui.shared.repository.ROLE_RESOURCEObj;
import cn.ennwifi.solu.ui.shared.repository.USERObj;
import cn.ennwifi.solu.ui.shared.repository.USER_ROLEObj;

/**
 * UI Service.
 *
 * @author zhangjianshe
 */
public class AdminUiServerServlet extends CheckAdminTokenServlet implements IAdminService {



  /*
   * (non-Javadoc)
   * 
   * @see cn.ennwifi.hangye.monitor.ui.server.servlet.CheckTokenServlet#
   * extendCheckToken(java.util.List)
   */
  @Override
  public void extendCheckToken(List<String> methodList) {
    super.extendCheckToken(methodList);

    methodList.add("adminLogin");
    methodList.add("sessionUser");
    methodList.add("getUserByToken");
  }

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The Constant log. */
  private static final Log LOG = Logs.getLog("AdminUiServer");

  /** The authority service. */
  AdminService adminService;

  /**
   * 获取 Spring容器中的 认证对象.
   *
   * @return the authority service
   */
  private synchronized AdminService getAdminService() {
    if (adminService == null) {
      adminService = SpringService.getBean(AdminService.class);
    }
    return adminService;
  }



  @Override
  public AdminLoginResponse adminLogin(String username, String pwd, String type)
      throws ServerException {
    LoginReqData req = new LoginReqData();
    req.username = username;
    req.password = pwd;
    req.type = type;
    AdminLoginResponse resp = null;
    try {
      resp = getAdminService().login(req, getThreadLocalRequest());
    } catch (Exception e) {
      String content = "尝试登陆系统失败" + e.getMessage();
      throw new ServerException(e.getMessage());
    }
    String content = "用户" + req.username + "登陆成功";
    processLoginResult(resp);
    return resp;
  }

  @Override
  public List<RESOURCEObj> getAllMenu() throws ServerException {
    return getDao().query(RESOURCEObj.class,
        Cnd.NEW().asc(RESOURCEObj.FLD_PID).asc(RESOURCEObj.FLD_RANK));
  }



  @Override
  public RESOURCEObj saveMenu(RESOURCEObj resource) throws ServerException {
    if (resource.getID() == null) {
      resource.setCLICK(0l);
      getDao().insert(resource);

      if (resource.getROOTID() == null) {
        resource.setROOTID(resource.getID());
        getDao().update(resource);
      }
    } else {
      getDao().update(resource);
    }
    return resource;
  }

  @Override
  public void deleteResource(final Long resourceId) throws ServerException {
    final USERObj admin = requestUser();

    Trans.exec(new Atom() {
      @Override
      public void run() {
        RESOURCEObj res = getDao().fetch(RESOURCEObj.class, resourceId);
        int count =
            getDao().count(RESOURCEObj.class, Cnd.where(RESOURCEObj.FLD_PID, "=", resourceId));
        if (count > 0) {
          String content = "试图删除资源" + res.getNAME() + "失败，不能删除有子节点的目录";
          systemLog(admin, Actions.UPDATE.name, content);
          throw new ServerException("不能删除有子节点的目录");
        }


        Cnd where = Cnd.where(ROLE_RESOURCEObj.FLD_RES_ID, "=", resourceId);
        getDao().clear(ROLE_RESOURCEObj.class, where);
        getDao().delete(RESOURCEObj.class, resourceId);
        String content = "删除资源" + res.getNAME();
        systemLog(admin, Actions.UPDATE.name, content);
      }
    });
  }

  @Override
  public List<ROLEObj> getAllRole() throws ServerException {
    return getDao().query(ROLEObj.class, null);
  }

  @Override
  public ROLEObj saveAdminRole(ROLEObj role) throws ServerException {
    USERObj admin = requestUser();
    if (role.getID() == null) {
      Cnd where = Cnd.where(ROLEObj.FLD_NAME, "=", role.getNAME());
      ROLEObj roleS = getDao().fetch(ROLEObj.class, where);
      if (roleS != null) {
        throw new ServerException("服务器中已存在这个角色");
      }


      String content = "新建角色" + role.getNAME() + "成功";
      systemLog(admin, Actions.CREATE.name, content);

      getDao().insert(role);
    } else {
      Cnd where = Cnd.where("NAME", "=", role.getNAME());
      ROLEObj roleS = getDao().fetch(ROLEObj.class, where);
      if (roleS != null && !roleS.getID().equals(role.getID())) {
        throw new ServerException("服务器中已存在这个角色");
      }

      String content = "更新角色" + role.getNAME() + "成功";
      systemLog(admin, Actions.UPDATE.name, content);
      getDao().update(role);
    }
    return role;
  }

  @Override
  public boolean deleteAdminRole(Long roleid) throws ServerException {
    USERObj admin = requestUser();
    ROLEObj role = getDao().fetch(ROLEObj.class, roleid);
    if (role == null) {
      String content = "删除角色" + roleid + "失败";
      systemLog(admin, Actions.DELETE.name, content);
    }
    String content = "删除角色" + role.getNAME() + "成功";
    systemLog(admin, Actions.DELETE.name, content);
    getDao().delete(ROLEObj.class, roleid);
    return true;
  }

  @Override
  public Boolean updateAdminRoleMenu(Long roleid, Long resourceId, boolean addOrRemove)
      throws ServerException {
    USERObj admin = requestUser();
    Cnd where = Cnd.where(ROLE_RESOURCEObj.FLD_ROLE_ID, "=", roleid);
    where = where.and(ROLE_RESOURCEObj.FLD_RES_ID, "=", resourceId);

    if (addOrRemove) {
      ROLE_RESOURCEObj obj = getDao().fetch(ROLE_RESOURCEObj.class, where);
      if (obj == null) {
        obj = new ROLE_RESOURCEObj();
        obj.setRES_ID(resourceId);
        obj.setROLE_ID(roleid);
        getDao().insert(obj);
        String content = "对角色" + roleid + "授权" + resourceId;
        systemLog(admin, Actions.CREATE.name, content);


      }
    } else {
      getDao().clear(ROLE_RESOURCEObj.class, where);
      String content = "对角色" + roleid + "取消授权" + resourceId;
      systemLog(admin, Actions.DELETE.name, content);

    }
    return true;
  }

  /**
   * 后台保存用户的配置信息
   */
  @Override
  public USERObj saveAdminUser(USERObj user) throws ServerException {


    if (user.getID() == null) {
      // 检查是否有相同的用户名
      USERObj adminUser =
          getDao().fetch(USERObj.class, Cnd.where(USERObj.FLD_NAME, "=", user.getNAME()));
      // 检查前台是否有相同的用户名
      USERObj frontUser =
          getDao().fetch(USERObj.class, Cnd.where(USERObj.FLD_NAME, "=", user.getNAME()));

      if (adminUser != null || frontUser != null) {
        throw new ServerException("数据库中有相同的用户名");
      }
      user.setPWD(Lang.md5(user.getPWD()));
      user.setUPDATE_TIME(new Timestamp(System.currentTimeMillis()));

      // 检查真实名称
      if (Strings.isEmpty(user.getREAL_NAME())) {
        user.setREAL_NAME(user.getNAME());
      }
      user.setACCOUNT_TYPE("1");
      user.setTOKEN(UUID.randomUUID().toString());
      String hash = Lang.sha1(user.getNAME() + user.getACCOUNT_TYPE());
      user.setHASH(hash);
      user.setENABLED(1);
      user.setTITLE("");

      getDao().insert(user);

      String content = "用户" + user.getNAME() + "登陆 创建相关的前台用户";
      systemLog(user, Actions.CREATE.name, content);

    } else {
      // 名字不允许修改
      if (!Strings.isEmpty(user.getPWD())) {
        // 需要修改密码
        user.setPWD(Lang.md5(user.getPWD()));
        Daos.ext(getDao(), FieldFilter.locked(USERObj.class, "^REAL_NAME|UPDATE_TIME|TOKEN$"))
            .update(user);
      } else {
        // 不许要修改密码
        Daos.ext(getDao(), FieldFilter.locked(USERObj.class, "^REAL_NAME|UPDATE_TIME|PWD|TOKEN$"))
            .update(user);
      }
    }
    return user;
  }


  @Override
  public boolean updateAdminUserRole(Long userid, Long roleid, Boolean addOrRemove)
      throws ServerException {
    USERObj admin = requestUser();
    Cnd where = Cnd.where(USER_ROLEObj.FLD_ROLE_ID, "=", roleid);
    where = where.and(USER_ROLEObj.FLD_USER_ID, "=", userid);
    if (addOrRemove) {
      USER_ROLEObj obj = getDao().fetch(USER_ROLEObj.class, where);
      if (obj == null) {
        obj = new USER_ROLEObj();
        obj.setUSER_ID(userid);
        obj.setROLE_ID(roleid);
        getDao().insert(obj);
        String content = "对用户" + userid + "授权角色" + roleid;
        systemLog(admin, Actions.UPDATE.name, content);

      }
    } else {
      String content = "对用户" + userid + "取消角色授权" + roleid;
      systemLog(admin, Actions.UPDATE.name, content);

      getDao().clear(USER_ROLEObj.class, where);
    }
    return true;
  }

  @Override
  public List<USER_ROLEObj> getAdminUserRole(Long userid) throws ServerException {
    return getDao().query(USER_ROLEObj.class, Cnd.where(USER_ROLEObj.FLD_USER_ID, "=", userid));
  }

  @Override
  public PagerData<RESOURCEObj> adminUserMainMenu() throws ServerException {
    USERObj user = requestUser();
    List<RESOURCEObj> list = getAdminService().userMainMenu(user.getID(), 1);
    PagerData<RESOURCEObj> r = new PagerData<RESOURCEObj>();
    r.setData(list);
    return r;
  }



  @Override
  public List<RESOURCEObj> adminSubMenu(int menuId) throws ServerException {
    List<RESOURCEObj> menus = getAdminService().subMenu(menuId);
    return menus;
  }

  /*
   * (non-Javadoc)
   * 
   * @see cn.ennwifi.hangye.monitor.ui.client.rpc.IUiServer#getUserByToken(java. lang.String)
   */
  @Override
  public AdminLoginResponse getUserByToken(String token) throws ServerException {

    // 检查Session中是否有该用户

    USERObj admin = getAdminService().sessionUser(getThreadLocalRequest());
    if (admin != null) {
    } else {
      admin = getAdminService().findUserByToken(token);
    }

    AdminLoginResponse r = new AdminLoginResponse();
    r.user = admin;
    processLoginResult(r);
    return r;
  }

  /**
   * 处理登录成功后返回的客户端配置信息
   * 
   * @param response
   */
  private void processLoginResult(AdminLoginResponse response) {
    UIProperties properties = SpringService.getBean(UIProperties.class);
    response.imagePrefix = properties.getImagePrefix();
    response.imageUploadAction = getBasePath() + "fileupload";
    try {
      String compile = Resources.readCompileInformation();
      response.compile = compile;
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (response.user != null) {
      CookieTools.addCookie(getThreadLocalResponse(), "ADMIN-TOKEN", response.user.getTOKEN(), "/",
          -1);
      CookieTools
          .addCookie(getThreadLocalResponse(), "USER-NAME", response.user.getNAME(), "/", -1);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see cn.ennwifi.hangye.monitor.ui.client.rpc.IUiServer#getAuthorityInfo(java. lang.String)
   */
  @Override
  public RESOURCEObj getMenuInfo(Integer id) throws ServerException {
    Cnd where = Cnd.where(RESOURCEObj.FLD_ID, "=", id);
    return getDao().fetch(RESOURCEObj.class, where);
  }

  @Override
  public PagerData<USERObj> findUserByQuery(String query, PagerData<USERObj> pager)
      throws ServerException {
    String val = "%" + query + "%";
    Cnd where = Cnd.where(USERObj.FLD_NAME, "like", val);
    where.or(USERObj.FLD_NAME, "like", val);
    where.or(USERObj.FLD_MOBILE, "like", val);
    where.limit(1, 10);
    List<USERObj> list = getDao().query(USERObj.class, where);
    pager.setData(list);
    return pager;
  }

  @Override
  public PagerData<USERObj> searchUserList(SearchReq req) throws ServerException {
    return getAdminService().searchUserList(req);

  }

  @Override
  public List<RESOURCEObj> adminAllMenu(int rootMenuId) throws ServerException {
    return getDao().query(
        RESOURCEObj.class,
        Cnd.where(RESOURCEObj.FLD_ROOTID, "=", rootMenuId).asc(RESOURCEObj.FLD_PID)
            .asc(RESOURCEObj.FLD_RANK));
  }

  @Override
  public List<ROLE_RESOURCEObj> getRoleResource(Long roleId) {
    Cnd where = Cnd.where(ROLE_RESOURCEObj.FLD_ROLE_ID, "=", roleId);
    where.asc(ROLE_RESOURCEObj.FLD_RES_ID);
    return getDao().query(ROLE_RESOURCEObj.class, where);
  }


  /**
   * 简化版的系统模块日志
   * 
   * @param admin
   * @param action
   * @param content
   */
  private void systemLog(USERObj admin, String action, String content) {

  }

  @Override
  public boolean updateRoleResource(Long roleId, List<Long> resourceIds) {
    USERObj admin = requestUser();
    Cnd where = Cnd.where(ROLE_RESOURCEObj.FLD_ROLE_ID, "=", roleId);

    List<ROLE_RESOURCEObj> list = new ArrayList<ROLE_RESOURCEObj>();
    for (Long resId : resourceIds) {
      ROLE_RESOURCEObj o = new ROLE_RESOURCEObj();
      o.setRES_ID(resId);
      o.setROLE_ID(roleId);
      list.add(o);
    }
    getDao().clear(ROLE_RESOURCEObj.class, where);
    String content = "对角色" + roleId + "授权" + Lang.concat(",", resourceIds).toString();


    getDao().fastInsert(list);
    return true;
  }

  /**
   * 用户是否拥有某个资源的访问权限
   * 
   * @param resid
   * @return
   * @throws ServerException
   */
  @Override
  public Boolean isUserOwnResource(Long resid) throws ServerException {
    try {
      USERObj admin = requestUser();
      return getAdminService().userOwnResource(admin.getID(), resid);
    } catch (Exception e) {
      throw new ServerException(e.getMessage());
    }
  }

  @Override
  public List<METAObj> fetchMetaData() throws ServerException {
    return getAdminService().fetchAllMetaData();
  }

  @Override
  public Boolean deleteMetaData(Integer metaId) throws ServerException {
    return getAdminService().deleteMetaData(metaId);
  }

  @Override
  public METAObj saveOrUpdateMetaData(METAObj meta) throws ServerException {
    return getAdminService().saveOrUpdateMetaData(meta);
  }



  @Override
  public APP_DATAObj getAppConfigure() throws ServerException {
    return getDao().fetch(APP_DATAObj.class, 1l);
  }

  @Override
  public APP_DATAObj saveOrUpdateAppConfigure(APP_DATAObj app) {
    getDao().update(app);
    return app;
  }



  @Override
  public List<METAObj> getMetaData(String catalog, Boolean includeSub) throws ServerException {
    // TODO Auto-generated method stub
    return null;
  }
}
