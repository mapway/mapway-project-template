
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 <br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         id   应用ID Long<br/>
 *         name   名称 String<br/>
 *         logo   logo String<br/>
 *         service_tel   服务电话 String<br/>
 *         enteriprise   企业名称 String<br/>
 *         copyright   版权信息 String<br/>
 *         icp   icp备案 String<br/>
 *         appkey   关键字信息 String<br/>
 */

@Table("APP_DATA")
public class APP_DATAObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_APP_DATA="APP_DATA";
  public APP_DATAObj() {
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
      if (FLD_LOGO.equals(fieldName)) {
        return LOGO;
      }
      if (FLD_SERVICE_TEL.equals(fieldName)) {
        return SERVICE_TEL;
      }
      if (FLD_ENTERIPRISE.equals(fieldName)) {
        return ENTERIPRISE;
      }
      if (FLD_COPYRIGHT.equals(fieldName)) {
        return COPYRIGHT;
      }
      if (FLD_ICP.equals(fieldName)) {
        return ICP;
      }
      if (FLD_APPKEY.equals(fieldName)) {
        return APPKEY;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 8) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return NAME;
      }
      if (fieldIndex == 2) {
        return LOGO;
      }
      if (fieldIndex == 3) {
        return SERVICE_TEL;
      }
      if (fieldIndex == 4) {
        return ENTERIPRISE;
      }
      if (fieldIndex == 5) {
        return COPYRIGHT;
      }
      if (fieldIndex == 6) {
        return ICP;
      }
      if (fieldIndex == 7) {
        return APPKEY;
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
   * @return id  应用ID  BIGINT
  */
  public Long getID() {
    return ID;
  }

  /**
   * 设置字段id的值.
   * @param id  应用ID  BIGINT
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

  /**
   * 字段logo在数据中的名称.
   */
  public static final String FLD_LOGO="logo";

  /**
   * 获取字段logo的索引值.
   */
  public static final Integer IDX_LOGO=2;
 /**
   * 字段logo.
   */
	@Column("logo")
  private String LOGO;

  /**
   * 返回字段logo的值.
   * @return logo  logo  VARCHAR
  */
  public String getLOGO() {
    return LOGO;
  }

  /**
   * 设置字段logo的值.
   * @param logo  logo  VARCHAR
   */
  public void setLOGO(String logo) {
    this.LOGO=logo;
  }

  /**
   * 字段service_tel在数据中的名称.
   */
  public static final String FLD_SERVICE_TEL="service_tel";

  /**
   * 获取字段service_tel的索引值.
   */
  public static final Integer IDX_SERVICE_TEL=3;
 /**
   * 字段service_tel.
   */
	@Column("service_tel")
  private String SERVICE_TEL;

  /**
   * 返回字段service_tel的值.
   * @return service_tel  服务电话  VARCHAR
  */
  public String getSERVICE_TEL() {
    return SERVICE_TEL;
  }

  /**
   * 设置字段service_tel的值.
   * @param service_tel  服务电话  VARCHAR
   */
  public void setSERVICE_TEL(String service_tel) {
    this.SERVICE_TEL=service_tel;
  }

  /**
   * 字段enteriprise在数据中的名称.
   */
  public static final String FLD_ENTERIPRISE="enteriprise";

  /**
   * 获取字段enteriprise的索引值.
   */
  public static final Integer IDX_ENTERIPRISE=4;
 /**
   * 字段enteriprise.
   */
	@Column("enteriprise")
  private String ENTERIPRISE;

  /**
   * 返回字段enteriprise的值.
   * @return enteriprise  企业名称  VARCHAR
  */
  public String getENTERIPRISE() {
    return ENTERIPRISE;
  }

  /**
   * 设置字段enteriprise的值.
   * @param enteriprise  企业名称  VARCHAR
   */
  public void setENTERIPRISE(String enteriprise) {
    this.ENTERIPRISE=enteriprise;
  }

  /**
   * 字段copyright在数据中的名称.
   */
  public static final String FLD_COPYRIGHT="copyright";

  /**
   * 获取字段copyright的索引值.
   */
  public static final Integer IDX_COPYRIGHT=5;
 /**
   * 字段copyright.
   */
	@Column("copyright")
  private String COPYRIGHT;

  /**
   * 返回字段copyright的值.
   * @return copyright  版权信息  VARCHAR
  */
  public String getCOPYRIGHT() {
    return COPYRIGHT;
  }

  /**
   * 设置字段copyright的值.
   * @param copyright  版权信息  VARCHAR
   */
  public void setCOPYRIGHT(String copyright) {
    this.COPYRIGHT=copyright;
  }

  /**
   * 字段icp在数据中的名称.
   */
  public static final String FLD_ICP="icp";

  /**
   * 获取字段icp的索引值.
   */
  public static final Integer IDX_ICP=6;
 /**
   * 字段icp.
   */
	@Column("icp")
  private String ICP;

  /**
   * 返回字段icp的值.
   * @return icp  icp备案  VARCHAR
  */
  public String getICP() {
    return ICP;
  }

  /**
   * 设置字段icp的值.
   * @param icp  icp备案  VARCHAR
   */
  public void setICP(String icp) {
    this.ICP=icp;
  }

  /**
   * 字段appkey在数据中的名称.
   */
  public static final String FLD_APPKEY="appkey";

  /**
   * 获取字段appkey的索引值.
   */
  public static final Integer IDX_APPKEY=7;
 /**
   * 字段appkey.
   */
	@Column("appkey")
  private String APPKEY;

  /**
   * 返回字段appkey的值.
   * @return appkey  关键字信息  VARCHAR
  */
  public String getAPPKEY() {
    return APPKEY;
  }

  /**
   * 设置字段appkey的值.
   * @param appkey  关键字信息  VARCHAR
   */
  public void setAPPKEY(String appkey) {
    this.APPKEY=appkey;
  }

}
