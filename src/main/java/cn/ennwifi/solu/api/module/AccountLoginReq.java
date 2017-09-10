package cn.ennwifi.solu.api.module;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

@Doc(value = "登录请求参数")
public class AccountLoginReq extends Req {

  @NotEmpty(message = "账户类型只能选择0或者1")
  @NotNull
  @ApiField(value = "账户类型 0->集团账号 1->注册账号", example = "1")
  public String accountType;

  @Length(min = 4, max = 30, message = "用户名在4-30之间")
  @NotNull(message = "用户名不能为空")
  @ApiField(value = "用户名", example = "zhangjsf")
  public String userName;

  @NotNull(message = "密码不能为空")
  @ApiField(value = "密码", example = "12345678")
  @Length(min = 4, max = 80, message = "密码长度需要大于4个字符")
  public String password;

  @ApiField(value = "第三方登录设置此值会元数据返回到返回值中", example = "extradata")
  public String url;
}
