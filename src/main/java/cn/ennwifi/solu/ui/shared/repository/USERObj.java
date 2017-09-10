
package cn.ennwifi.solu.ui.shared.repository;

import java.util.Date;

import org.nutz.dao.entity.annotation.*;
import java.math.BigDecimal;

/**
 * 数据库表 用户表<br/>
 * @author zhangjsf@enn.cn

 *         <b>字段列表</b><br/>

 *         id   用户ID Long<br/>
 *         account_type    String<br/>
 *         hash    String<br/>
 *         name    String<br/>
 *         pwd    String<br/>
 *         real_name    String<br/>
 *         avator    String<br/>
 *         gender    String<br/>
 *         email    String<br/>
 *         mobile    String<br/>
 *         title    String<br/>
 *         token    String<br/>
 *         create_time    java.sql.Timestamp<br/>
 *         update_time    java.sql.Timestamp<br/>
 *         is_send_message    Integer<br/>
 *         enabled    Integer<br/>
 *         disabled_msg    String<br/>
 *         recommend_code    String<br/>
 *         last_time   最后登录时间 java.sql.Timestamp<br/>
 *         user_type   用户类型 String<br/>
 *         user_identities   用户标识 String<br/>
 */

@Table("USER")
public class USERObj implements java.io.Serializable,com.google.gwt.user.client.rpc.IsSerializable,
    com.ksyzt.gwt.client.data.IFieldValue{
  /**
   * 缺省的序列化值.
  */
  private static final long serialVersionUID = 1L;

  /**
     * 表明. 
     */
  public static final String TBL_USER="USER";
  public USERObj() {
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
      if (FLD_ACCOUNT_TYPE.equals(fieldName)) {
        return ACCOUNT_TYPE;
      }
      if (FLD_HASH.equals(fieldName)) {
        return HASH;
      }
      if (FLD_NAME.equals(fieldName)) {
        return NAME;
      }
      if (FLD_PWD.equals(fieldName)) {
        return PWD;
      }
      if (FLD_REAL_NAME.equals(fieldName)) {
        return REAL_NAME;
      }
      if (FLD_AVATOR.equals(fieldName)) {
        return AVATOR;
      }
      if (FLD_GENDER.equals(fieldName)) {
        return GENDER;
      }
      if (FLD_EMAIL.equals(fieldName)) {
        return EMAIL;
      }
      if (FLD_MOBILE.equals(fieldName)) {
        return MOBILE;
      }
      if (FLD_TITLE.equals(fieldName)) {
        return TITLE;
      }
      if (FLD_TOKEN.equals(fieldName)) {
        return TOKEN;
      }
      if (FLD_CREATE_TIME.equals(fieldName)) {
        return CREATE_TIME;
      }
      if (FLD_UPDATE_TIME.equals(fieldName)) {
        return UPDATE_TIME;
      }
      if (FLD_IS_SEND_MESSAGE.equals(fieldName)) {
        return IS_SEND_MESSAGE;
      }
      if (FLD_ENABLED.equals(fieldName)) {
        return ENABLED;
      }
      if (FLD_DISABLED_MSG.equals(fieldName)) {
        return DISABLED_MSG;
      }
      if (FLD_RECOMMEND_CODE.equals(fieldName)) {
        return RECOMMEND_CODE;
      }
      if (FLD_LAST_TIME.equals(fieldName)) {
        return LAST_TIME;
      }
      if (FLD_USER_TYPE.equals(fieldName)) {
        return USER_TYPE;
      }
      if (FLD_USER_IDENTITIES.equals(fieldName)) {
        return USER_IDENTITIES;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 21) {
      if (fieldIndex == 0) {
        return ID;
      }
      if (fieldIndex == 1) {
        return ACCOUNT_TYPE;
      }
      if (fieldIndex == 2) {
        return HASH;
      }
      if (fieldIndex == 3) {
        return NAME;
      }
      if (fieldIndex == 4) {
        return PWD;
      }
      if (fieldIndex == 5) {
        return REAL_NAME;
      }
      if (fieldIndex == 6) {
        return AVATOR;
      }
      if (fieldIndex == 7) {
        return GENDER;
      }
      if (fieldIndex == 8) {
        return EMAIL;
      }
      if (fieldIndex == 9) {
        return MOBILE;
      }
      if (fieldIndex == 10) {
        return TITLE;
      }
      if (fieldIndex == 11) {
        return TOKEN;
      }
      if (fieldIndex == 12) {
        return CREATE_TIME;
      }
      if (fieldIndex == 13) {
        return UPDATE_TIME;
      }
      if (fieldIndex == 14) {
        return IS_SEND_MESSAGE;
      }
      if (fieldIndex == 15) {
        return ENABLED;
      }
      if (fieldIndex == 16) {
        return DISABLED_MSG;
      }
      if (fieldIndex == 17) {
        return RECOMMEND_CODE;
      }
      if (fieldIndex == 18) {
        return LAST_TIME;
      }
      if (fieldIndex == 19) {
        return USER_TYPE;
      }
      if (fieldIndex == 20) {
        return USER_IDENTITIES;
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
   * @return id  用户ID  BIGINT
  */
  public Long getID() {
    return ID;
  }

  /**
   * 设置字段id的值.
   * @param id  用户ID  BIGINT
   */
  public void setID(Long id) {
    this.ID=id;
  }

  /**
   * 字段account_type在数据中的名称.
   */
  public static final String FLD_ACCOUNT_TYPE="account_type";

  /**
   * 获取字段account_type的索引值.
   */
  public static final Integer IDX_ACCOUNT_TYPE=1;
 /**
   * 字段account_type.
   */
	@Column("account_type")
  private String ACCOUNT_TYPE;

  /**
   * 返回字段account_type的值.
   * @return account_type    VARCHAR
  */
  public String getACCOUNT_TYPE() {
    return ACCOUNT_TYPE;
  }

  /**
   * 设置字段account_type的值.
   * @param account_type    VARCHAR
   */
  public void setACCOUNT_TYPE(String account_type) {
    this.ACCOUNT_TYPE=account_type;
  }

  /**
   * 字段hash在数据中的名称.
   */
  public static final String FLD_HASH="hash";

  /**
   * 获取字段hash的索引值.
   */
  public static final Integer IDX_HASH=2;
 /**
   * 字段hash.
   */
	@Column("hash")
  private String HASH;

  /**
   * 返回字段hash的值.
   * @return hash    VARCHAR
  */
  public String getHASH() {
    return HASH;
  }

  /**
   * 设置字段hash的值.
   * @param hash    VARCHAR
   */
  public void setHASH(String hash) {
    this.HASH=hash;
  }

  /**
   * 字段name在数据中的名称.
   */
  public static final String FLD_NAME="name";

  /**
   * 获取字段name的索引值.
   */
  public static final Integer IDX_NAME=3;
 /**
   * 字段name.
   */
	@Column("name")
  private String NAME;

  /**
   * 返回字段name的值.
   * @return name    VARCHAR
  */
  public String getNAME() {
    return NAME;
  }

  /**
   * 设置字段name的值.
   * @param name    VARCHAR
   */
  public void setNAME(String name) {
    this.NAME=name;
  }

  /**
   * 字段pwd在数据中的名称.
   */
  public static final String FLD_PWD="pwd";

  /**
   * 获取字段pwd的索引值.
   */
  public static final Integer IDX_PWD=4;
 /**
   * 字段pwd.
   */
	@Column("pwd")
  private String PWD;

  /**
   * 返回字段pwd的值.
   * @return pwd    VARCHAR
  */
  public String getPWD() {
    return PWD;
  }

  /**
   * 设置字段pwd的值.
   * @param pwd    VARCHAR
   */
  public void setPWD(String pwd) {
    this.PWD=pwd;
  }

  /**
   * 字段real_name在数据中的名称.
   */
  public static final String FLD_REAL_NAME="real_name";

  /**
   * 获取字段real_name的索引值.
   */
  public static final Integer IDX_REAL_NAME=5;
 /**
   * 字段real_name.
   */
	@Column("real_name")
  private String REAL_NAME;

  /**
   * 返回字段real_name的值.
   * @return real_name    VARCHAR
  */
  public String getREAL_NAME() {
    return REAL_NAME;
  }

  /**
   * 设置字段real_name的值.
   * @param real_name    VARCHAR
   */
  public void setREAL_NAME(String real_name) {
    this.REAL_NAME=real_name;
  }

  /**
   * 字段avator在数据中的名称.
   */
  public static final String FLD_AVATOR="avator";

  /**
   * 获取字段avator的索引值.
   */
  public static final Integer IDX_AVATOR=6;
 /**
   * 字段avator.
   */
	@Column("avator")
  private String AVATOR;

  /**
   * 返回字段avator的值.
   * @return avator    VARCHAR
  */
  public String getAVATOR() {
    return AVATOR;
  }

  /**
   * 设置字段avator的值.
   * @param avator    VARCHAR
   */
  public void setAVATOR(String avator) {
    this.AVATOR=avator;
  }

  /**
   * 字段gender在数据中的名称.
   */
  public static final String FLD_GENDER="gender";

  /**
   * 获取字段gender的索引值.
   */
  public static final Integer IDX_GENDER=7;
 /**
   * 字段gender.
   */
	@Column("gender")
  private String GENDER;

  /**
   * 返回字段gender的值.
   * @return gender    VARCHAR
  */
  public String getGENDER() {
    return GENDER;
  }

  /**
   * 设置字段gender的值.
   * @param gender    VARCHAR
   */
  public void setGENDER(String gender) {
    this.GENDER=gender;
  }

  /**
   * 字段email在数据中的名称.
   */
  public static final String FLD_EMAIL="email";

  /**
   * 获取字段email的索引值.
   */
  public static final Integer IDX_EMAIL=8;
 /**
   * 字段email.
   */
	@Column("email")
  private String EMAIL;

  /**
   * 返回字段email的值.
   * @return email    VARCHAR
  */
  public String getEMAIL() {
    return EMAIL;
  }

  /**
   * 设置字段email的值.
   * @param email    VARCHAR
   */
  public void setEMAIL(String email) {
    this.EMAIL=email;
  }

  /**
   * 字段mobile在数据中的名称.
   */
  public static final String FLD_MOBILE="mobile";

  /**
   * 获取字段mobile的索引值.
   */
  public static final Integer IDX_MOBILE=9;
 /**
   * 字段mobile.
   */
	@Column("mobile")
  private String MOBILE;

  /**
   * 返回字段mobile的值.
   * @return mobile    VARCHAR
  */
  public String getMOBILE() {
    return MOBILE;
  }

  /**
   * 设置字段mobile的值.
   * @param mobile    VARCHAR
   */
  public void setMOBILE(String mobile) {
    this.MOBILE=mobile;
  }

  /**
   * 字段title在数据中的名称.
   */
  public static final String FLD_TITLE="title";

  /**
   * 获取字段title的索引值.
   */
  public static final Integer IDX_TITLE=10;
 /**
   * 字段title.
   */
	@Column("title")
  private String TITLE;

  /**
   * 返回字段title的值.
   * @return title    VARCHAR
  */
  public String getTITLE() {
    return TITLE;
  }

  /**
   * 设置字段title的值.
   * @param title    VARCHAR
   */
  public void setTITLE(String title) {
    this.TITLE=title;
  }

  /**
   * 字段token在数据中的名称.
   */
  public static final String FLD_TOKEN="token";

  /**
   * 获取字段token的索引值.
   */
  public static final Integer IDX_TOKEN=11;
 /**
   * 字段token.
   */
	@Column("token")
  private String TOKEN;

  /**
   * 返回字段token的值.
   * @return token    VARCHAR
  */
  public String getTOKEN() {
    return TOKEN;
  }

  /**
   * 设置字段token的值.
   * @param token    VARCHAR
   */
  public void setTOKEN(String token) {
    this.TOKEN=token;
  }

  /**
   * 字段create_time在数据中的名称.
   */
  public static final String FLD_CREATE_TIME="create_time";

  /**
   * 获取字段create_time的索引值.
   */
  public static final Integer IDX_CREATE_TIME=12;
 /**
   * 字段create_time.
   */
	@Column("create_time")
  private java.sql.Timestamp CREATE_TIME;

  /**
   * 返回字段create_time的值.
   * @return create_time    TIMESTAMP
  */
  public java.sql.Timestamp getCREATE_TIME() {
    return CREATE_TIME;
  }

  /**
   * 设置字段create_time的值.
   * @param create_time    TIMESTAMP
   */
  public void setCREATE_TIME(java.sql.Timestamp create_time) {
    this.CREATE_TIME=create_time;
  }

  /**
   * 字段update_time在数据中的名称.
   */
  public static final String FLD_UPDATE_TIME="update_time";

  /**
   * 获取字段update_time的索引值.
   */
  public static final Integer IDX_UPDATE_TIME=13;
 /**
   * 字段update_time.
   */
	@Column("update_time")
  private java.sql.Timestamp UPDATE_TIME;

  /**
   * 返回字段update_time的值.
   * @return update_time    TIMESTAMP
  */
  public java.sql.Timestamp getUPDATE_TIME() {
    return UPDATE_TIME;
  }

  /**
   * 设置字段update_time的值.
   * @param update_time    TIMESTAMP
   */
  public void setUPDATE_TIME(java.sql.Timestamp update_time) {
    this.UPDATE_TIME=update_time;
  }

  /**
   * 字段is_send_message在数据中的名称.
   */
  public static final String FLD_IS_SEND_MESSAGE="is_send_message";

  /**
   * 获取字段is_send_message的索引值.
   */
  public static final Integer IDX_IS_SEND_MESSAGE=14;
 /**
   * 字段is_send_message.
   */
	@Column("is_send_message")
  private Integer IS_SEND_MESSAGE;

  /**
   * 返回字段is_send_message的值.
   * @return is_send_message    INTEGER
  */
  public Integer getIS_SEND_MESSAGE() {
    return IS_SEND_MESSAGE;
  }

  /**
   * 设置字段is_send_message的值.
   * @param is_send_message    INTEGER
   */
  public void setIS_SEND_MESSAGE(Integer is_send_message) {
    this.IS_SEND_MESSAGE=is_send_message;
  }

  /**
   * 字段enabled在数据中的名称.
   */
  public static final String FLD_ENABLED="enabled";

  /**
   * 获取字段enabled的索引值.
   */
  public static final Integer IDX_ENABLED=15;
 /**
   * 字段enabled.
   */
	@Column("enabled")
  private Integer ENABLED;

  /**
   * 返回字段enabled的值.
   * @return enabled    INTEGER
  */
  public Integer getENABLED() {
    return ENABLED;
  }

  /**
   * 设置字段enabled的值.
   * @param enabled    INTEGER
   */
  public void setENABLED(Integer enabled) {
    this.ENABLED=enabled;
  }

  /**
   * 字段disabled_msg在数据中的名称.
   */
  public static final String FLD_DISABLED_MSG="disabled_msg";

  /**
   * 获取字段disabled_msg的索引值.
   */
  public static final Integer IDX_DISABLED_MSG=16;
 /**
   * 字段disabled_msg.
   */
	@Column("disabled_msg")
  private String DISABLED_MSG;

  /**
   * 返回字段disabled_msg的值.
   * @return disabled_msg    VARCHAR
  */
  public String getDISABLED_MSG() {
    return DISABLED_MSG;
  }

  /**
   * 设置字段disabled_msg的值.
   * @param disabled_msg    VARCHAR
   */
  public void setDISABLED_MSG(String disabled_msg) {
    this.DISABLED_MSG=disabled_msg;
  }

  /**
   * 字段recommend_code在数据中的名称.
   */
  public static final String FLD_RECOMMEND_CODE="recommend_code";

  /**
   * 获取字段recommend_code的索引值.
   */
  public static final Integer IDX_RECOMMEND_CODE=17;
 /**
   * 字段recommend_code.
   */
	@Column("recommend_code")
  private String RECOMMEND_CODE;

  /**
   * 返回字段recommend_code的值.
   * @return recommend_code    VARCHAR
  */
  public String getRECOMMEND_CODE() {
    return RECOMMEND_CODE;
  }

  /**
   * 设置字段recommend_code的值.
   * @param recommend_code    VARCHAR
   */
  public void setRECOMMEND_CODE(String recommend_code) {
    this.RECOMMEND_CODE=recommend_code;
  }

  /**
   * 字段last_time在数据中的名称.
   */
  public static final String FLD_LAST_TIME="last_time";

  /**
   * 获取字段last_time的索引值.
   */
  public static final Integer IDX_LAST_TIME=18;
 /**
   * 字段last_time.
   */
	@Column("last_time")
  private java.sql.Timestamp LAST_TIME;

  /**
   * 返回字段last_time的值.
   * @return last_time  最后登录时间  TIMESTAMP
  */
  public java.sql.Timestamp getLAST_TIME() {
    return LAST_TIME;
  }

  /**
   * 设置字段last_time的值.
   * @param last_time  最后登录时间  TIMESTAMP
   */
  public void setLAST_TIME(java.sql.Timestamp last_time) {
    this.LAST_TIME=last_time;
  }

  /**
   * 字段user_type在数据中的名称.
   */
  public static final String FLD_USER_TYPE="user_type";

  /**
   * 获取字段user_type的索引值.
   */
  public static final Integer IDX_USER_TYPE=19;
 /**
   * 字段user_type.
   */
	@Column("user_type")
  private String USER_TYPE;

  /**
   * 返回字段user_type的值.
   * @return user_type  用户类型  VARCHAR
  */
  public String getUSER_TYPE() {
    return USER_TYPE;
  }

  /**
   * 设置字段user_type的值.
   * @param user_type  用户类型  VARCHAR
   */
  public void setUSER_TYPE(String user_type) {
    this.USER_TYPE=user_type;
  }

  /**
   * 字段user_identities在数据中的名称.
   */
  public static final String FLD_USER_IDENTITIES="user_identities";

  /**
   * 获取字段user_identities的索引值.
   */
  public static final Integer IDX_USER_IDENTITIES=20;
 /**
   * 字段user_identities.
   */
	@Column("user_identities")
  private String USER_IDENTITIES;

  /**
   * 返回字段user_identities的值.
   * @return user_identities  用户标识  VARCHAR
  */
  public String getUSER_IDENTITIES() {
    return USER_IDENTITIES;
  }

  /**
   * 设置字段user_identities的值.
   * @param user_identities  用户标识  VARCHAR
   */
  public void setUSER_IDENTITIES(String user_identities) {
    this.USER_IDENTITIES=user_identities;
  }

}
