package cn.ennwifi.solu.configure.data;

import javax.sql.DataSource;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ennwifi.solu.configure.DataSourceConfigure;
import cn.ennwifi.solu.configure.ldap.LdapConfigure;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataConfigure {

  private Log log = Logs.getLog(DataConfigure.class);

  @Autowired
  DataSourceConfigure configure;

  @Autowired
  LdapConfigure ldapConfigure;

  @Autowired
  @Bean
  public DataSource dataSource() {

    log.info("\r\n" + Json.toJson(configure));

    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUrl(configure.getUrl());
    dataSource.setPassword(configure.getPassword());
    dataSource.setUsername(configure.getUser());
    dataSource.setDriverClassName(configure.getDriver());
    dataSource.setMaxActive(30);
    dataSource.setMaxWait(5 * 1000);
    dataSource.setTestOnBorrow(true);
    dataSource.setTestWhileIdle(true);
    dataSource.setTestOnReturn(true);


    StatFilter statFilter = new StatFilter();
    dataSource.getProxyFilters().add(statFilter);
    return dataSource;

  }

  @Autowired
  @Bean
  public Dao dao(DataSource ds) {
    return new NutDao(ds);
  }

}
