package cn.ennwifi.solu.ui.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;


/**
 * 服务代理工厂类.
 *
 * @author zhangjianshe
 */
public class AdminProxy {

  /** The proxy. */
  private static IAdminServiceAsync PROXY;
  private static RequestBuilderWithToken requestBuilder;

  /**
   * Gets the.
   *
   * @return the i ui server async
   */
  public static IAdminServiceAsync get() {
    if (PROXY == null) {
      PROXY = GWT.create(IAdminService.class);
      requestBuilder = new RequestBuilderWithToken();
      ServiceDefTarget t = (ServiceDefTarget) PROXY;
      t.setServiceEntryPoint(GWT.getModuleBaseURL() + "../adminserver");
      t.setRpcRequestBuilder(requestBuilder);

    }
    return PROXY;
  }
}
