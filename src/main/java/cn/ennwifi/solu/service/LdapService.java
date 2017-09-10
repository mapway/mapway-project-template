package cn.ennwifi.solu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.nutz.mapl.Mapl;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Component;

import cn.ennwifi.solu.configure.ldap.LdapConfigure;
import cn.ennwifi.solu.configure.ldap.LdapException;


@Component
public class LdapService {

  private final static Logger log = Logger.getLogger(LdapService.class.getName());
  private LdapContextSource ldapContext;
  private LdapTemplate template;

  public LdapService(LdapConfigure configure) {

    ldapContext = new LdapContextSource();
    ldapContext.setUrl(configure.getUrl());
    ldapContext.setBase(configure.getBase());
    ldapContext.setUserDn(configure.getUserDn());
    ldapContext.setPassword(configure.getPassword());
    ldapContext.setAnonymousReadOnly(true);

    ldapContext.afterPropertiesSet();


    template = new LdapTemplate(ldapContext);
  }


  /**
   * 根据用户名到LDAP服务器中获取用户的DN
   * 
   * @param userName
   * @return
   */
  public <T> T authenticate(final Class<T> type, String userName, String password)
      throws LdapException {
    EqualsFilter f = new EqualsFilter("uid", userName);

    boolean success = template.authenticate(LdapUtils.emptyLdapName(), f.toString(), password);
    if (success) {
      List<T> result =
          template.search(LdapUtils.emptyLdapName(), f.toString(), new AbstractContextMapper<T>() {
            @Override
            protected T doMapFromContext(DirContextOperations ctx) {
              Attributes attributes = ctx.getAttributes();
              return fromAttribute(type, attributes);
            }
          });
      if (result.size() == 0) {
        throw LdapException.fail("没有找到");
      } else if (result.size() > 1) {
        throw LdapException.fail("多个用户");
      }
      return result.get(0);
    } else {
      throw LdapException.fail("密码错误");
    }
  }

  /**
   * 根据LDAP属性转换为对象
   * 
   * @param attributes
   * @return
   */
  protected <T> T fromAttribute(Class<T> type, Attributes attributes) {
    Map<String, Object> kvs = new HashMap<String, Object>();

    NamingEnumeration<? extends Attribute> all = attributes.getAll();
    while (all.hasMoreElements()) {
      // 处理属性的多个值，这里只获取第一个值
      try {
        Attribute at = all.next();
        String key = at.getID();
        String value = null;
        NamingEnumeration<?> vs = at.getAll();

        if (vs.hasMore()) {
          value = (String) vs.next();
        }
        if (value != null) {
          kvs.put(key, value);
        }
      } catch (NamingException e) {
        e.printStackTrace();
      }
    }
    T obj = Mapl.maplistToT(Mapl.toMaplist(kvs), type);
    return obj;
  }
}
