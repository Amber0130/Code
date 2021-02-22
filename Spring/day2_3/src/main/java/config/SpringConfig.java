package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.lang.annotation.Documented;

/**
 * 该类是一个配置类
 * 他和bean的作用是一样的
 * Spring中的新注解
 * Configruation
 *      作用：当前类是一个配置类
 *      当配置类作为AnnotationConfigApplicationContext的参数时
 @ComponentScan
        用于通过注解指定Spring在创建时要扫描的包
        属性 value和basePackages作用是一样的都是用于指定创建容器是扫描的包
等同于xml中的
 <context:component-scan base-package="com.itheima"></context:component-scan>
 Bean
        作用：用于把当前方法的返回值作为bean对象存入spring容器IOC容器中
        属性：
               name指定bean 默认值是当前方法的名称
        细节
                当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的Bean对象
                查找的方式和Autowired注解的作用是一样的
 import用于到与其他配置类
    属性：value其他类的字节吗
 有import为主配置类，导入的都是子配置类
 PropertySource
 用于指定properties文件的位置
 属性
 value文件的名称和路径
 classpath类路径下

 */
//@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setUser(username);
            ds.setJdbcUrl(url);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
