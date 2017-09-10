
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 <br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         id   元数据ID Integer<br/>
 *         catalog   分类目录 String<br/>
 *         name   名称 String<br/>
 *         code   code String<br/>
 *         rank   排序 Integer<br/>
 *         pid   父ID Integer<br/>
 */

@Table("META")
public class METAObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_META="META";
  public METAObj() {
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
      if (FLD_CATALOG.equals(fieldName)) {
        return CATALOG;
      }
      if (FLD_NAME.equals(fieldName)) {
        return NAME;
      }
      if (FLD_CODE.equals(fieldName)) {
        return CODE;
      }
      if (FLD_RANK.equals(fieldName)) {
        return RANK;
      }
      if (FLD_PID.equals(fieldName)) {
        return PID;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 6) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return CATALOG;
      }
      if (fieldIndex == 2) {
        return NAME;
      }
      if (fieldIndex == 3) {
        return CODE;
      }
      if (fieldIndex == 4) {
        return RANK;
      }
      if (fieldIndex == 5) {
        return PID;
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
   * @return id  元数据ID  INTEGER
  */
  public Integer getID() {
    return ID;
  }

  /**
   * 设置字段id的值.
   * @param id  元数据ID  INTEGER
   */
  public void setID(Integer id) {
    this.ID=id;
  }

  /**
   * 字段catalog在数据中的名称.
   */
  public static final String FLD_CATALOG="catalog";

  /**
   * 获取字段catalog的索引值.
   */
  public static final Integer IDX_CATALOG=1;
 /**
   * 字段catalog.
   */
	@Column("catalog")
  private String CATALOG;

  /**
   * 返回字段catalog的值.
   * @return catalog  分类目录  VARCHAR
  */
  public String getCATALOG() {
    return CATALOG;
  }

  /**
   * 设置字段catalog的值.
   * @param catalog  分类目录  VARCHAR
   */
  public void setCATALOG(String catalog) {
    this.CATALOG=catalog;
  }

  /**
   * 字段name在数据中的名称.
   */
  public static final String FLD_NAME="name";

  /**
   * 获取字段name的索引值.
   */
  public static final Integer IDX_NAME=2;
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

  /**
   * 字段code在数据中的名称.
   */
  public static final String FLD_CODE="code";

  /**
   * 获取字段code的索引值.
   */
  public static final Integer IDX_CODE=3;
 /**
   * 字段code.
   */
	@Column("code")
  private String CODE;

  /**
   * 返回字段code的值.
   * @return code  code  VARCHAR
  */
  public String getCODE() {
    return CODE;
  }

  /**
   * 设置字段code的值.
   * @param code  code  VARCHAR
   */
  public void setCODE(String code) {
    this.CODE=code;
  }

  /**
   * 字段rank在数据中的名称.
   */
  public static final String FLD_RANK="rank";

  /**
   * 获取字段rank的索引值.
   */
  public static final Integer IDX_RANK=4;
 /**
   * 字段rank.
   */
	@Column("rank")
  private Integer RANK;

  /**
   * 返回字段rank的值.
   * @return rank  排序  INTEGER
  */
  public Integer getRANK() {
    return RANK;
  }

  /**
   * 设置字段rank的值.
   * @param rank  排序  INTEGER
   */
  public void setRANK(Integer rank) {
    this.RANK=rank;
  }

  /**
   * 字段pid在数据中的名称.
   */
  public static final String FLD_PID="pid";

  /**
   * 获取字段pid的索引值.
   */
  public static final Integer IDX_PID=5;
 /**
   * 字段pid.
   */
	@Column("pid")
  private Integer PID;

  /**
   * 返回字段pid的值.
   * @return pid  父ID  INTEGER
  */
  public Integer getPID() {
    return PID;
  }

  /**
   * 设置字段pid的值.
   * @param pid  父ID  INTEGER
   */
  public void setPID(Integer pid) {
    this.PID=pid;
  }

}
