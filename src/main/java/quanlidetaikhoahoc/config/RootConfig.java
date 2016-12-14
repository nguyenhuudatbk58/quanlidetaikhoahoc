package quanlidetaikhoahoc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import quanlidetaikhoahoc.ApplicationProperty;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"quanlidetaikhoahoc.config.security"})
public class RootConfig {
	
	


	@Bean(name = "hbnProperties")
	public Properties hbnProperties() {

		Properties hbnProperties = new Properties();
		hbnProperties.put("hibernate.dialect", ApplicationProperty.HB_DIALECT);
		hbnProperties.put("hibernate.show_sql", ApplicationProperty.HB_SHOW_SQL);
		hbnProperties.put("hibernate.connection.CharSet", ApplicationProperty.HB_CONNECTION_CHARSET);
		hbnProperties.put("hibernate.connection.characterEncoding", ApplicationProperty.HB_CONNECTION_CHARACTER_ENCODING);
		hbnProperties.put("hibernate.connection.useUnicode",ApplicationProperty.HB_CONNECTION_USE_UNICODE);
		hbnProperties.put("hibernate.format_sql", ApplicationProperty.HB_FORMAT_SQL);
		hbnProperties.put("hibernate.use_sql_comments", ApplicationProperty.HB_USE_SQL_COMMENT); 
		
		return hbnProperties;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(ApplicationProperty.DB_DRIVER);
		dataSource.setUrl(ApplicationProperty.DB_URL);
		dataSource.setUsername(ApplicationProperty.DB_USERNAME);
		dataSource.setPassword(ApplicationProperty.DB_PASSWORD);

		return dataSource;
	}

	@Bean(name = "sessionFactoryBean")
	public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource,
			Properties hbnProperties) {

		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(ApplicationProperty.HB_PACKAGE_TO_SCAN);
		factory.setHibernateProperties(hbnProperties);
		
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager =new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTransaction() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
