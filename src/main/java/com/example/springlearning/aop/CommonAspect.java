package com.example.springlearning.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAspect {


    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void beforeController() {
        System.out.println("Before executing controller method");
    }


    @Before("execution(* com.example.springlearning.service..*(..))")
    public void beforeAbstractService() {
        System.out.println("before abstract service");
    }
}
