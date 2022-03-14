package com.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.code.entities.Role;
import com.code.entities.User;

@Configuration
@EnableTransactionManagement

public class HibernateConfig {
	
	 @Autowired
	    private ApplicationContext context;

	    @Bean
	    public LocalSessionFactoryBean getSessionFactory() {
	        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
	        factoryBean.setAnnotatedClasses(User.class, Role.class);
	        return factoryBean;
	    }
	    
	    
//
//	    @Bean
//	    @Autowired
//	    public HibernateTransactionManager getTransactionManager() {
//	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//	        transactionManager.setSessionFactory(getSessionFactory().getObject());
//	        return transactionManager;
//	    }

}
