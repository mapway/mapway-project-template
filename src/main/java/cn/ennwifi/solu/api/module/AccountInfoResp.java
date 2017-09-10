package cn.ennwifi.solu.api.module;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

@Doc(value = "获取账户信息")
public class AccountInfoResp extends Resp {

  @ApiField(value = "账号的基本信息")
  public Account account;

}
