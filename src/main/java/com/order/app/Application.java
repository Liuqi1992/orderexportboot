package com.order.app;

import com.order.jwt.Audiences;
import com.order.utils.Constants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.PropertyConfigurator;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages= "com.order")
@EnableAutoConfiguration
@EntityScan(basePackages="com.order.pojo")
@EnableJpaRepositories(basePackages= "com.order.repository")
@EnableConfigurationProperties(Audiences.class)
@SpringBootApplication
@EnableScheduling
@MapperScan("com.order.dao")
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	static {
		try{
			// 初始化log4j
			String log4jPath = "";
			if(Constants.LOG_MODE == 1){
				// 配置线上地址
				log4jPath = Application.class.getClassLoader().getResource("").getPath()+"log4j.properties";
				logger.info("Log4j线上生产模式初始化。。。");
			}else{
				// 配置本地地址
				log4jPath = Application.class.getClassLoader().getResource("").getPath()+"log4j.properties";
				logger.info("Log4j线下开发模式初始化。。。");
			}
			logger.info("初始化Log4j。。。。");
			logger.info("path is "+ log4jPath);
			PropertyConfigurator.configure(log4jPath);
		}catch (Exception e){
			logger.error(e.toString());
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/orderexport");
		dataSource.setUsername("root");
		dataSource.setPassword("ts123456");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}

}
