package cn.ennwifi.solu.ui.shared.module;

import org.hibernate.validator.constraints.NotBlank;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

/**
 * 继承对象的请求 都要求进行用户验证.
 *
 * @author zhangjianshe
 */
@Doc("验证合法用户的请求")
public class UserReq {

  /** The token. */
  @ApiField(value = "用户请求TOKEN,参见用户登录接口", example = "213232tkelwfeirwuewr")
  @NotBlank(message = "用户TOKEN字段不能为空")
  public String token;
}
