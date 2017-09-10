package cn.ennwifi.solu.tools;

import javax.servlet.http.HttpServletRequest;

import org.nutz.lang.Lang;
import org.nutz.lang.hardware.Networks;

import cn.ennwifi.solu.service.AppService;
import cn.ennwifi.solu.service.SpringService;
import cn.ennwifi.solu.ui.shared.repository.APP_DATAObj;

/**
 * 为JSP页面提供简介的方法调用.
 *
 * @author zhangjianshe
 */
public class Jsps {

  /**
   * 获取客户的访问IP地址.
   *
   * @param request the request
   * @return the client ip
   */
  public static String getClientIp(HttpServletRequest request) {
    return Lang.getIP(request);
  }

  /**
   * 获取客户的访问IP地址.
   *
   * @return the local ip
   */
  public static String getLocalIp() {
    return Networks.ipv4();
  }


  /**
   * 从应用环境中获取Bean.
   *
   * @param <T> the generic type
   * @param request the request
   * @param classBean the c
   * @return the t
   */
  public static <T> T findBean(Class<T> classBean) {
    return SpringService.getBean(classBean);
  }

  /**
   * 应用程序信息
   * 
   * @return
   */
  public static APP_DATAObj appInfo() {
    return findBean(AppService.class).appInfo();
  }
}
