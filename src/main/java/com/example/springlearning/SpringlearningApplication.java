package com.example.springlearning;

import jakarta.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Map;

@SpringBootApplication
public class SpringlearningApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringlearningApplication.class, args);
        UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        AuthenticationProvider authenticationProvider;
        BasicAuthenticationFilter basicAuthenticationFilter;
        Map<String,Filter> filterMap = context.getBeansOfType(Filter.class);
        filterMap.forEach((beanName,filter)->{
            System.out.println(filter.getClass().getName());
        });
    }

}
