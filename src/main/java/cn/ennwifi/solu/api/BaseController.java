package cn.ennwifi.solu.api;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ennwifi.solu.service.AdminService;
import cn.ennwifi.solu.tools.CookieTools;
import cn.ennwifi.solu.ui.shared.repository.USERObj;

/**
 * 控制器基类
 * 
 * @author zhangjianshe
 */
public class BaseController {

  @Autowired
  private Dao dao;

  public Dao getDao() {
    return dao;
  }



  @Autowired
  AdminService adminService;

  /**
   * 查询后台用户信息.
   */
  public USERObj getAdminUser(HttpServletRequest request) {
    String token = CookieTools.getCookieValue(request, "ADMIN-TOKEN");
    return adminService.findUserByToken(token);
  }

}
