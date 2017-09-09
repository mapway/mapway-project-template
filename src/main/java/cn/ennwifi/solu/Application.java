package cn.ennwifi.solu;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import cn.ennwifi.solu.configure.DataSourceConfigure;
import cn.ennwifi.solu.configure.SystemPropertyDefaultsInitializer;
import cn.ennwifi.solu.configure.UIProperties;
import cn.ennwifi.solu.configure.ldap.LdapConfigure;

/**
 * @author ShaoRuolin
 */
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({LdapConfigure.class, DataSourceConfigure.class, UIProperties.class})
public class Application {
  private static Logger logger = Logger.getLogger("MainApplication");

  /**
   * @param args
   */
  public static void main(String[] args) {

    SystemPropertyDefaultsInitializer initializer = new SystemPropertyDefaultsInitializer();
    initializer.initialize();

    ApplicationContext ctx = SpringApplication.run(Application.class, args);

    String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
    for (String profile : activeProfiles) {
      logger.info("Spring Boot 使用profile为:" + profile);
    }
  }



}
