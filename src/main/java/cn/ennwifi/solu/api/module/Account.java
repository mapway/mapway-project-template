package cn.ennwifi.solu.api.module;

import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.Doc;

@Doc(value = "账户信息")
public class Account {
  @ApiField(value = "用户ID", example = "1321")
  public Long uid;

  @ApiField(value = "账户类型 0->集团账号 1->注册账号", example = "0")
  public String accountType;

  @ApiField(value = "用户名称", example = "zhangjsf")
  public String userName;

  @ApiField(value = "真实名称", example = "张建设")
  public String realName;

  @ApiField(value = "用户头像", example = "http://img.ennwifi.cn/avator/123.png")
  public String avator;

  @ApiField(value = "手机", example = "15910868680")
  public String phone;

  @ApiField(value = "邮箱", example = "zhangjsf@enn.cn")
  public String email;

  @ApiField(value = "TOKEN", example = "0cbd1a60-38b5-43b9-b751-fe580b9e7908")
  public String token;

  @ApiField(value = "所在公司", example = "泛能网络科技")
  public String company;

  @ApiField(value = "公司中的部门", example = "创新中心")
  public String department;

  @ApiField(value = "职务", example = "IT架构师")
  public String office;

  @ApiField(value = "联系方式", example = "望京融科中心A-1807")
  public String contact;


  @ApiField(value = "用户身份投资商    010301\r\n" + "设计院 010302\r\n" + "建安商 010303\r\n"
      + "设备商 010304\r\n" + "总包商 010305\r\n" + "运营商 010306\r\n" + "其他服务商   010307\r\n"
      + "能源用户    010308\r\n" + "政府机关    010309\r\n" + "中介  010310\r\n" + "投资商    020601\r\n"
      + "设计院 020602\r\n" + "建安商 020603\r\n" + "设备商 020604\r\n" + "运营商 020605\r\n"
      + "其他服务商   020606", example = "010301")
  public String identity;

  @ApiField(value = "用户类型:010101->个人用户 010102->企业用户", example = "010101")
  public String userType;


}
