
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 角色资源ID<br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         role_id   角色ID Long<br/>
 *         res_id   资源ID Long<br/>
 */

@Table("ROLE_RESOURCE")
@PK({"role_id","res_id"})
public class ROLE_RESOURCEObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_ROLE_RESOURCE="ROLE_RESOURCE";
  public ROLE_RESOURCEObj() {
  }
  /**
   * 根据字段名称获取字段的值. 
   */
  @Override
  public Object getFieldValue(String fieldName,Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_ROLE_ID.equals(fieldName)) {
        return ROLE_ID;
      }
      if (FLD_RES_ID.equals(fieldName)) {
        return RES_ID;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 2) {
      if (fieldIndex == 0) {
        return ROLE_ID;
      }
      if (fieldIndex == 1) {
        return RES_ID;
      }
    } else {
      return null;
    }
    return null;
  }

  /**
   * 字段role_id在数据中的名称.
   */
  public static final String FLD_ROLE_ID="role_id";

  /**
   * 获取字段role_id的索引值.
   */
  public static final Integer IDX_ROLE_ID=0;
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

  /**
   * 字段res_id在数据中的名称.
   */
  public static final String FLD_RES_ID="res_id";

  /**
   * 获取字段res_id的索引值.
   */
  public static final Integer IDX_RES_ID=1;
 /**
   * 字段res_id.
   */
	@Column("res_id")
  private Long RES_ID;

  /**
   * 返回字段res_id的值.
   * @return res_id  资源ID  BIGINT
  */
  public Long getRES_ID() {
    return RES_ID;
  }

  /**
   * 设置字段res_id的值.
   * @param res_id  资源ID  BIGINT
   */
  public void setRES_ID(Long res_id) {
    this.RES_ID=res_id;
  }

}
