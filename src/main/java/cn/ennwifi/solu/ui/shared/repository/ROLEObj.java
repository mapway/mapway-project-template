
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 角色表<br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         id   角色ID Long<br/>
 *         name   角色名称 String<br/>
 *         summary   角色说明 String<br/>
 */

@Table("ROLE")
public class ROLEObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_ROLE="ROLE";
  public ROLEObj() {
  }
  /**
   * 根据字段名称获取字段的值. 
   */
  @Override
  public Object getFieldValue(String fieldName,Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_ID.equals(fieldName)) {
        return ID;
      }
      if (FLD_NAME.equals(fieldName)) {
        return NAME;
      }
      if (FLD_SUMMARY.equals(fieldName)) {
        return SUMMARY;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 3) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return NAME;
      }
      if (fieldIndex == 2) {
        return SUMMARY;
      }
    } else {
      return null;
    }
    return null;
  }

  /**
   * 字段id在数据中的名称.
   */
  public static final String FLD_ID="id";

  /**
   * 获取字段id的索引值.
   */
  public static final Integer IDX_ID=0;
 /**
   * 字段id.
   */
	@Id
  private Long ID;

  /**
   * 返回字段id的值.
   * @return id  角色ID  BIGINT
  */
  public Long getID() {
    return ID;
  }

  /**
   * 设置字段id的值.
   * @param id  角色ID  BIGINT
   */
  public void setID(Long id) {
    this.ID=id;
  }

  /**
   * 字段name在数据中的名称.
   */
  public static final String FLD_NAME="name";

  /**
   * 获取字段name的索引值.
   */
  public static final Integer IDX_NAME=1;
 /**
   * 字段name.
   */
	@Column("name")
  private String NAME;

  /**
   * 返回字段name的值.
   * @return name  角色名称  VARCHAR
  */
  public String getNAME() {
    return NAME;
  }

  /**
   * 设置字段name的值.
   * @param name  角色名称  VARCHAR
   */
  public void setNAME(String name) {
    this.NAME=name;
  }

  /**
   * 字段summary在数据中的名称.
   */
  public static final String FLD_SUMMARY="summary";

  /**
   * 获取字段summary的索引值.
   */
  public static final Integer IDX_SUMMARY=2;
 /**
   * 字段summary.
   */
	@Column("summary")
  private String SUMMARY;

  /**
   * 返回字段summary的值.
   * @return summary  角色说明  VARCHAR
  */
  public String getSUMMARY() {
    return SUMMARY;
  }

  /**
   * 设置字段summary的值.
   * @param summary  角色说明  VARCHAR
   */
  public void setSUMMARY(String summary) {
    this.SUMMARY=summary;
  }

}
