package cn.ennwifi.solu.servlets;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Component;

import cn.ennwifi.solu.ui.shared.servlet.AdminUiServerServlet;


/**
 * UI Server 初始化.
 *
 * @author zhangjianshe
 */
@Component
public class AdminServer extends ServletRegistrationBean {


  public AdminServer() {

    // servlet
    AdminUiServerServlet servlet = new AdminUiServerServlet();
    // servlet parameters
    Map<String, String> params = getParameters();

    setServlet(servlet);
    addUrlMappings("/adminserver/*");
    setInitParameters(params);
    setLoadOnStartup(1);
  }

  /**
   * 生成文档的配置信息.
   * 
   * @return 配置信息
   */
  private Map<String, String> getParameters() {
    Map<String, String> params = new HashMap<String, String>();

    return params;
  }

}
