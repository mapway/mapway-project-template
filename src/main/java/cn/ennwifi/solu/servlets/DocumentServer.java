package cn.ennwifi.solu.servlets;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.nutz.lang.Strings;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Component;

import cn.mapway.document.servlet.MapwayDocServlet;


/**
 * 对应新版 Document 的Servlet mapway-doc-ui 0.0.38
 * 
 * @author zhangjianshe
 */
@Component
public class DocumentServer extends ServletRegistrationBean {

  /** The log. */
  private static Logger LOG = Logger.getLogger("SERVLET-DOCUMENT");

  public DocumentServer() {
    MapwayDocServlet servlet = new MapwayDocServlet();

    // servlet parameters
    Map<String, String> params = getParameters();

    setServlet(servlet);
    addUrlMappings("/doc/*");
    setInitParameters(params);
    setLoadOnStartup(1);
  }

  private Map<String, String> getParameters() {
    Map<String, String> params = new HashMap<String, String>();

    params.put(MapwayDocServlet.PARAM_ANT_HOME, Strings.sNull(System.getenv("ANT_HOME")));
    params.put(MapwayDocServlet.PARAM_AUTHOR, "zhangjsf@enn.com");
    params.put(MapwayDocServlet.PARAM_CONNECTOR_CLASS_NAME, "NeyunApiConnector");
    params.put(MapwayDocServlet.PARAM_CONNECTOR_PACKAGE_NAME, "cn.enn.neyun.api");
    params.put(MapwayDocServlet.PARAM_DOMAIN, "www.enn.cn");
    params.put(MapwayDocServlet.PARAM_SCAN_PACKAGES, "cn.ennwifi.solu");
    params.put(MapwayDocServlet.PARAM_TITLE, "泛能解决方案-接口文档");
    params.put(MapwayDocServlet.PARAM_COPY_RIGHT, "2016-2017 新奥集团");

    return params;
  }



}
