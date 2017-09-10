
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 用户角色表<br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         user_id   用户ID Long<br/>
 *         role_id   角色ID Long<br/>
 */

@Table("USER_ROLE")
@PK({"user_id","role_id"})
public class USER_ROLEObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_USER_ROLE="USER_ROLE";
  public USER_ROLEObj() {
  }
  /**
   * 根据字段名称获取字段的值. 
   */
  @Override
  public Object getFieldValue(String fieldName,Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_USER_ID.equals(fieldName)) {
        return USER_ID;
      }
      if (FLD_ROLE_ID.equals(fieldName)) {
        return ROLE_ID;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 2) {
      if (fieldIndex == 0) {
        return USER_ID;
      }
      if (fieldIndex == 1) {
        return ROLE_ID;
      }
    } else {
      return null;
    }
    return null;
  }

  /**
   * 字段user_id在数据中的名称.
   */
  public static final String FLD_USER_ID="user_id";

  /**
   * 获取字段user_id的索引值.
   */
  public static final Integer IDX_USER_ID=0;
 /**
   * 字段user_id.
   */
	@Column("user_id")
  private Long USER_ID;

  /**
   * 返回字段user_id的值.
   * @return user_id  用户ID  BIGINT
  */
  public Long getUSER_ID() {
    return USER_ID;
  }

  /**
   * 设置字段user_id的值.
   * @param user_id  用户ID  BIGINT
   */
  public void setUSER_ID(Long user_id) {
    this.USER_ID=user_id;
  }

  /**
   * 字段role_id在数据中的名称.
   */
  public static final String FLD_ROLE_ID="role_id";

  /**
   * 获取字段role_id的索引值.
   */
  public static final Integer IDX_ROLE_ID=1;
 /**
   * 字段role_id.
   */
	@Column("role_id")
  private Long ROLE_ID;

  /**
   * 返回字段role_id的值.
   * @return role_id  角色ID  BIGINT
  */
  public Long getROLE_ID() {
    return ROLE_ID;
  }

  /**
   * 设置字段role_id的值.
   * @param role_id  角色ID  BIGINT
   */
  public void setROLE_ID(Long role_id) {
    this.ROLE_ID=role_id;
  }

}
