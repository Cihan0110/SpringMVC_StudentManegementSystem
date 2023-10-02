package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.tpe") // Scan under com.tpe folder
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    // View Resolver
    @Bean
    public InternalResourceViewResolver viewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); // We are telling that we are going to use html inside the .jsp files
        resolver.setPrefix("/WEB-INF/views/"); // Find the view files
        resolver.setSuffix(".jsp"); // We are telling that we are using .jsp for view objects

        return resolver;

    }

    // CSS, images, static files, etc. does not need to be sent into the servlet.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") // Return files here as static
                .addResourceLocations("/resources/")
                .setCachePeriod(0); // Setting the time for caching period.
    }

}
