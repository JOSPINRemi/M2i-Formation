package org.example.demo_aop.service;

import org.example.demo_aop.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public void method() {
        System.out.println("method demoService");
        throw new RuntimeException();
    }

    public boolean methodReturnBoolean() {
        System.out.println("methodReturnBoolean demoService");
        return true;
    }

    @CustomAnnotation
    public void methodWithAnnotation() {
        System.out.println("methodWithAnnotation");
    }
}
