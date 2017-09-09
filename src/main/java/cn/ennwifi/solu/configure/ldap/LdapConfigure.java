package cn.ennwifi.solu.configure.ldap;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "ldap")
public class LdapConfigure {

  public LdapConfigure() {

  }

  public String url;
  public String base;
  public String userDn;
  public String password;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getUserDn() {
    return userDn;
  }

  public void setUserDn(String userDn) {
    this.userDn = userDn;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


}
