package cn.ennwifi.solu.ui.shared.module;

import cn.ennwifi.solu.ui.shared.repository.USERObj;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * 用户登录返回的数据.
 *
 * @author zhangjianshe
 */
public class AdminLoginResponse implements IsSerializable {

  /**
   * Instantiates a new login response.
   */
  public AdminLoginResponse() {}

  /** 当前登录用户. */
  public USERObj user;
  /**
   * 显示图片前缀
   */
  public String imagePrefix;
  /**
   * 上传图片URL
   */
  public String imageUploadAction;

  /**
   * 编译信息
   */
  public String compile;
}
