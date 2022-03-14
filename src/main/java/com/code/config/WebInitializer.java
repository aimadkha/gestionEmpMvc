package com.code.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
//	@Override
//	public void onStartup(ServletContext servletContext)
//	        throws ServletException {
//	      FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("my-filter", new LogFilter());
//	      //encodingFilter.setInitParameter("blah", "blah");
//	      encodingFilter.addMappingForUrlPatterns(null, false, "/user/*");
//	      super.onStartup(servletContext);
//	}
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HibernateConfig.class,AppRootCofig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ApplicationContextConfig.class};
    }
    
    
//    @Override
//	protected Filter[] getServletFilters() {
//		return new Filter[]{new LogFilter()};
//	}

    @Override
    protected String[] getServletMappings() {
        return new String [] {"/"};
    }

}
