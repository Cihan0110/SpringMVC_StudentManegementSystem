package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Instead of web.xml, we'll be using this class for configuration.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    // Hibernate/JDBC configurations
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // Servlet, HandlerMapping, ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    // To handle url and requests
    // http://localhost:8080/SpringMvc
    @Override
    protected String[] getServletMappings() {
        // Get the requests you receive from the current servlet.
        // "/" means, accept every request that you get.
        return new String[]{"/"};
    }
}