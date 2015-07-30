package net.study.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("net.study")
@EnableWebMvc   
@EnableTransactionManagement
public class AppConfig {

    @Bean(name = "viewResolver")
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/jsp/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }  

    /**
     * Hibernate 설정 시작 -----------------------------------------------------------------------------
     */
	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
			{
				setProperty("hibernate.show_sql", "true");
				setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			}
		};
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory().getObject());
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "net.study" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	    dataSource.setUsername("");
	    dataSource.setPassword("");
	 
	    // <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
	    return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
    /**
     * Hibernate 설정 끝 -----------------------------------------------------------------------------
     */

}
