package com.sumit.init;

import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextCleanupListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

@Slf4j
public class Initializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	private AnnotationConfigWebApplicationContext ctx = null;

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		SLF4JBridgeHandler.removeHandlersForRootLogger();
	    SLF4JBridgeHandler.install();
	    
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		//ctx.register(SecurityConfig.class);
		
		
		servletContext.addListener(new ContextLoaderListener(ctx));
		servletContext.addListener(new ContextCleanupListener());

		ctx.setServletContext(servletContext);
		servletContext.addFilter("CORSFilter", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, true, "/*");

		log.debug("application starting up");
		System.setProperty("spring.profiles.active", "web");
		
		Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
				new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true);
		
		log.debug("application started");
	}

	  @PreDestroy
	  protected final void cleanup() {
	    if (ctx != null) {
	      ctx.close();
	    }
	  }
	  
}
