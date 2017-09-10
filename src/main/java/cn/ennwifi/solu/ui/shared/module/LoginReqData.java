package cn.ennwifi.solu.ui.shared.module;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class LoginReqData.
 */
@Doc("登录系统数据")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginReqData {

  /** The username. */
  @ApiField("用户名")
  @NotBlank(message = "需要输入用户名username")
  @Length(min = 5, message = "用户名长度应大于5")
  public String username;

  /** The password. */
  @ApiField(value = "密码")
  @NotBlank(message = "需要输入密码passwod")
  public String password;

  /** The password. */
  @ApiField(value = "登录类型")
  @NotBlank(message = "选择登录方式")
  public String type;

}
