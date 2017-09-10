package cn.ennwifi.solu.api.module;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

@Doc(value = "获取账户信息请求参数")
public class AccountInfoReq extends Req {

  @ApiField(value = "账户的访问TOKEN", example = "0cbd1a60-38b5-43b9-b751-fe580b9e7908")
  public String token;

}
