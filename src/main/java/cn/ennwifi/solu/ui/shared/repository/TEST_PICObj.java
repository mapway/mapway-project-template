
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 <br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         id   图片ID Integer<br/>
 *         url   路径 String<br/>
 */

@Table("TEST_PIC")
public class TEST_PICObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_TEST_PIC="TEST_PIC";
  public TEST_PICObj() {
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
      if (FLD_URL.equals(fieldName)) {
        return URL;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 2) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return URL;
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
  private Integer ID;

  /**
   * 返回字段id的值.
   * @return id  图片ID  INTEGER
  */
  public Integer getID() {
    return ID;
  }

  /**
   * 设置字段id的值.
   * @param id  图片ID  INTEGER
   */
  public void setID(Integer id) {
    this.ID=id;
  }

  /**
   * 字段url在数据中的名称.
   */
  public static final String FLD_URL="url";

  /**
   * 获取字段url的索引值.
   */
  public static final Integer IDX_URL=1;
 /**
   * 字段url.
   */
	@Column("url")
  private String URL;

  /**
   * 返回字段url的值.
   * @return url  路径  VARCHAR
  */
  public String getURL() {
    return URL;
  }

  /**
   * 设置字段url的值.
   * @param url  路径  VARCHAR
   */
  public void setURL(String url) {
    this.URL=url;
  }

}
