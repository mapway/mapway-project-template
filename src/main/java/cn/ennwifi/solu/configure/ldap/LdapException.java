package cn.ennwifi.solu.configure.ldap;

/**
 * LdapException
 * 
 * @author zhangjianshe
 *
 */
public class LdapException extends RuntimeException {
  private static final long serialVersionUID = 1L;



  public LdapException() {
    super("");
  }

  public LdapException(String message) {
    super(message);

  }

  public LdapException(Throwable cause) {
    super(cause);

  }

  public LdapException(String message, Throwable cause) {
    super(message, cause);

  }

  public LdapException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }



  public static LdapException fail(String msg) {
    LdapException e = new LdapException(msg);
    return e;
  }

  public static LdapException ok() {
    return fail("SUCCESS");
  }



}
