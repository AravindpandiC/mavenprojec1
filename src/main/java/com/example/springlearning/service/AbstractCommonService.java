package com.example.springlearning.service;

public abstract class AbstractCommonService {

    public void method() {
        System.out.println("Executing method1 in AbstractCommonService");
    }

    public final void  method2() {
        System.out.println("Executing method2 in AbstractCommonService");
    }
}
