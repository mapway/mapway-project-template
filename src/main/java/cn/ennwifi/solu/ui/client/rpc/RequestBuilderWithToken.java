package cn.ennwifi.solu.ui.client.rpc;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.rpc.RpcRequestBuilder;

/**
 * Google rpc call with additional headers.
 * 
 * @author zhangjianshe
 *
 */
public class RequestBuilderWithToken extends RpcRequestBuilder {


  public RequestBuilderWithToken() {

  }

  @Override
  protected void doFinish(RequestBuilder rb) {
    super.doFinish(rb);

  }
}
