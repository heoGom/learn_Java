package org.example.springv3.core.config;

import org.example.springv3.core.filter.JwtAuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Controller, @RestController, @Service, @Repository, @Component, @Configuration

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<?> AuthorizationFilter() {
        FilterRegistrationBean<JwtAuthorizationFilter> bean = new FilterRegistrationBean(new JwtAuthorizationFilter());
        bean.addUrlPatterns("/api/*");
        bean.setOrder(0);
        return bean;
    }
}
