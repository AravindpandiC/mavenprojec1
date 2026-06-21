package com.example.springlearning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    final RateLimitHandlerInterceptor rateLimitHandlerInterceptor;

    public WebConfig(RateLimitHandlerInterceptor rateLimitHandlerInterceptor) {
        this.rateLimitHandlerInterceptor = rateLimitHandlerInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimitHandlerInterceptor)
                .addPathPatterns("/**");
    }
}
