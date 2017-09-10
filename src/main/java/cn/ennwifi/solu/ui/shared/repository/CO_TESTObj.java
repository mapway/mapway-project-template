
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 <br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         ID   工资ID Long<br/>
 *         name   名称 String<br/>
 */

@Table("CO_TEST")
public class CO_TESTObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_CO_TEST="CO_TEST";
  public CO_TESTObj() {
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
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 2) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return NAME;
      }
    } else {
      return null;
    }
    return null;
  }

  /**
   * 字段ID在数据中的名称.
   */
  public static final String FLD_ID="ID";

  /**
   * 获取字段ID的索引值.
   */
  public static final Integer IDX_ID=0;
 /**
   * 字段ID.
   */
	@Id
  private Long ID;

  /**
   * 返回字段ID的值.
   * @return ID  工资ID  BIGINT
  */
  public Long getID() {
    return ID;
  }

  /**
   * 设置字段ID的值.
   * @param id  工资ID  BIGINT
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
   * @return name  名称  VARCHAR
  */
  public String getNAME() {
    return NAME;
  }

  /**
   * 设置字段name的值.
   * @param name  名称  VARCHAR
   */
  public void setNAME(String name) {
    this.NAME=name;
  }

}
