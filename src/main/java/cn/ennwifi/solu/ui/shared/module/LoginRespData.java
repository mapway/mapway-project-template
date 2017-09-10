package cn.ennwifi.solu.ui.shared.module;

import cn.ennwifi.solu.ui.shared.repository.USERObj;
import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

/**
 * The Class LoginRespData.
 */
@Doc("登录系统返回数据")
public class LoginRespData extends RespData {

  /** The token. */
  @ApiField(value = "用户信息，包括token")
  public USERObj user = new USERObj();
}
