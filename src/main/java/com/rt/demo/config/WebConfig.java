package com.rt.demo.config;


import com.rt.demo.aspect.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Date: 2020/6/29 18:00
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private Interceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }
}