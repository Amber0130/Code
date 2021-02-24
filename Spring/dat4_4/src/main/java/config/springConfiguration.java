package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置类相当于xml
 */
@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class,transactionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement
public class springConfiguration {

}
