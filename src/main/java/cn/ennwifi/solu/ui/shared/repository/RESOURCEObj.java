
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 系统资源表<br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         id   资源ID Long<br/>
 *         name   资源名称 String<br/>
 *         para   模块参数 String<br/>
 *         pid   父ID Long<br/>
 *         icon   图标相对路径 String<br/>
 *         path   路径信息 String<br/>
 *         rank   排序 Integer<br/>
 *         summary   资源说明 String<br/>
 *         code   模块代码 String<br/>
 *         style   CSS样式 String<br/>
 *         click   点击次数 Long<br/>
 *         rootid   根ID Long<br/>
 */

@Table("RESOURCE")
public class RESOURCEObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_RESOURCE="RESOURCE";
  public RESOURCEObj() {
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
      if (FLD_PARA.equals(fieldName)) {
        return PARA;
      }
      if (FLD_PID.equals(fieldName)) {
        return PID;
      }
      if (FLD_ICON.equals(fieldName)) {
        return ICON;
      }
      if (FLD_PATH.equals(fieldName)) {
        return PATH;
      }
      if (FLD_RANK.equals(fieldName)) {
        return RANK;
      }
      if (FLD_SUMMARY.equals(fieldName)) {
        return SUMMARY;
      }
      if (FLD_CODE.equals(fieldName)) {
        return CODE;
      }
      if (FLD_STYLE.equals(fieldName)) {
        return STYLE;
      }
      if (FLD_CLICK.equals(fieldName)) {
        return CLICK;
      }
      if (FLD_ROOTID.equals(fieldName)) {
        return ROOTID;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 12) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return NAME;
      }
      if (fieldIndex == 2) {
        return PARA;
      }
      if (fieldIndex == 3) {
        return PID;
      }
      if (fieldIndex == 4) {
        return ICON;
      }
      if (fieldIndex == 5) {
        return PATH;
      }
      if (fieldIndex == 6) {
        return RANK;
      }
      if (fieldIndex == 7) {
        return SUMMARY;
      }
      if (fieldIndex == 8) {
        return CODE;
      }
      if (fieldIndex == 9) {
        return STYLE;
      }
      if (fieldIndex == 10) {
        return CLICK;
      }
      if (fieldIndex == 11) {
        return ROOTID;
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
   * @return id  资源ID  BIGINT
  */
  public Long getID() {
    return ID;
  }

  /**
   * 设置字段id的值.
   * @param id  资源ID  BIGINT
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
   * @return name  资源名称  VARCHAR
  */
  public String getNAME() {
    return NAME;
  }

  /**
   * 设置字段name的值.
   * @param name  资源名称  VARCHAR
   */
  public void setNAME(String name) {
    this.NAME=name;
  }

  /**
   * 字段para在数据中的名称.
   */
  public static final String FLD_PARA="para";

  /**
   * 获取字段para的索引值.
   */
  public static final Integer IDX_PARA=2;
 /**
   * 字段para.
   */
	@Column("para")
  private String PARA;

  /**
   * 返回字段para的值.
   * @return para  模块参数  VARCHAR
  */
  public String getPARA() {
    return PARA;
  }

  /**
   * 设置字段para的值.
   * @param para  模块参数  VARCHAR
   */
  public void setPARA(String para) {
    this.PARA=para;
  }

  /**
   * 字段pid在数据中的名称.
   */
  public static final String FLD_PID="pid";

  /**
   * 获取字段pid的索引值.
   */
  public static final Integer IDX_PID=3;
 /**
   * 字段pid.
   */
	@Column("pid")
  private Long PID;

  /**
   * 返回字段pid的值.
   * @return pid  父ID  BIGINT
  */
  public Long getPID() {
    return PID;
  }

  /**
   * 设置字段pid的值.
   * @param pid  父ID  BIGINT
   */
  public void setPID(Long pid) {
    this.PID=pid;
  }

  /**
   * 字段icon在数据中的名称.
   */
  public static final String FLD_ICON="icon";

  /**
   * 获取字段icon的索引值.
   */
  public static final Integer IDX_ICON=4;
 /**
   * 字段icon.
   */
	@Column("icon")
  private String ICON;

  /**
   * 返回字段icon的值.
   * @return icon  图标相对路径  VARCHAR
  */
  public String getICON() {
    return ICON;
  }

  /**
   * 设置字段icon的值.
   * @param icon  图标相对路径  VARCHAR
   */
  public void setICON(String icon) {
    this.ICON=icon;
  }

  /**
   * 字段path在数据中的名称.
   */
  public static final String FLD_PATH="path";

  /**
   * 获取字段path的索引值.
   */
  public static final Integer IDX_PATH=5;
 /**
   * 字段path.
   */
	@Column("path")
  private String PATH;

  /**
   * 返回字段path的值.
   * @return path  路径信息  VARCHAR
  */
  public String getPATH() {
    return PATH;
  }

  /**
   * 设置字段path的值.
   * @param path  路径信息  VARCHAR
   */
  public void setPATH(String path) {
    this.PATH=path;
  }

  /**
   * 字段rank在数据中的名称.
   */
  public static final String FLD_RANK="rank";

  /**
   * 获取字段rank的索引值.
   */
  public static final Integer IDX_RANK=6;
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
   * 字段summary在数据中的名称.
   */
  public static final String FLD_SUMMARY="summary";

  /**
   * 获取字段summary的索引值.
   */
  public static final Integer IDX_SUMMARY=7;
 /**
   * 字段summary.
   */
	@Column("summary")
  private String SUMMARY;

  /**
   * 返回字段summary的值.
   * @return summary  资源说明  VARCHAR
  */
  public String getSUMMARY() {
    return SUMMARY;
  }

  /**
   * 设置字段summary的值.
   * @param summary  资源说明  VARCHAR
   */
  public void setSUMMARY(String summary) {
    this.SUMMARY=summary;
  }

  /**
   * 字段code在数据中的名称.
   */
  public static final String FLD_CODE="code";

  /**
   * 获取字段code的索引值.
   */
  public static final Integer IDX_CODE=8;
 /**
   * 字段code.
   */
	@Column("code")
  private String CODE;

  /**
   * 返回字段code的值.
   * @return code  模块代码  VARCHAR
  */
  public String getCODE() {
    return CODE;
  }

  /**
   * 设置字段code的值.
   * @param code  模块代码  VARCHAR
   */
  public void setCODE(String code) {
    this.CODE=code;
  }

  /**
   * 字段style在数据中的名称.
   */
  public static final String FLD_STYLE="style";

  /**
   * 获取字段style的索引值.
   */
  public static final Integer IDX_STYLE=9;
 /**
   * 字段style.
   */
	@Column("style")
  private String STYLE;

  /**
   * 返回字段style的值.
   * @return style  CSS样式  VARCHAR
  */
  public String getSTYLE() {
    return STYLE;
  }

  /**
   * 设置字段style的值.
   * @param style  CSS样式  VARCHAR
   */
  public void setSTYLE(String style) {
    this.STYLE=style;
  }

  /**
   * 字段click在数据中的名称.
   */
  public static final String FLD_CLICK="click";

  /**
   * 获取字段click的索引值.
   */
  public static final Integer IDX_CLICK=10;
 /**
   * 字段click.
   */
	@Column("click")
  private Long CLICK;

  /**
   * 返回字段click的值.
   * @return click  点击次数  BIGINT
  */
  public Long getCLICK() {
    return CLICK;
  }

  /**
   * 设置字段click的值.
   * @param click  点击次数  BIGINT
   */
  public void setCLICK(Long click) {
    this.CLICK=click;
  }

  /**
   * 字段rootid在数据中的名称.
   */
  public static final String FLD_ROOTID="rootid";

  /**
   * 获取字段rootid的索引值.
   */
  public static final Integer IDX_ROOTID=11;
 /**
   * 字段rootid.
   */
	@Column("rootid")
  private Long ROOTID;

  /**
   * 返回字段rootid的值.
   * @return rootid  根ID  BIGINT
  */
  public Long getROOTID() {
    return ROOTID;
  }

  /**
   * 设置字段rootid的值.
   * @param rootid  根ID  BIGINT
   */
  public void setROOTID(Long rootid) {
    this.ROOTID=rootid;
  }

}
