package cn.ennwifi.solu.api.module;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

@Doc(value = "账户登录返回消息")
public class AccountLoginResp extends Resp {
  @ApiField(value = "跳转的URL", example = "http://www.baidu.com")
  public String url;

  @ApiField(value = "账号的基本信息")
  public Account account;

}
