package cn.ennwifi.solu.api.module;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

/**
 * 接口返回值基类.
 * 
 * @author zhangjianshe
 *
 */
@Doc(value = "接口返回数据的基类")
public class Resp {

  @ApiField(value = "返回码 0 成功 其他错误", example = "0")
  public Integer retCode;
  @ApiField(value = "返回的消息", example = "登录用户名没有注册")
  public String msg;

  /**
   * 返回无消息的正确响应.
   */
  public void ok() {
    ok("success");
  }

  /**
   * 返回正确的消息.
   * 
   * @param msg
   */
  public void ok(String msg) {
    this.msg = msg;
    retCode = 0;
  }

  /**
   * 返回错误.
   * 
   * @param code
   * @param msg
   */
  public void fail(Integer code, String msg) {
    this.msg = msg;
    this.retCode = code;
  }

  /**
   * 返回错误.
   * 
   * @param code =1
   * @param msg
   */
  public void fail(String msg) {
    this.msg = msg;
    this.retCode = 1;
  }
}
