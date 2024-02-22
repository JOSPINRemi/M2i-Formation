package org.example.library_management.apect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;

@Component
@Aspect
public class PerformanceAspect {
    private Long start;

    @Pointcut("@annotation(org.example.library_management.annotation.PerformanceAnnotation)")
    public void performancePointCut() {
    }

    @Before("performancePointCut()")
    public void beforeMethodWithPerformanceAnnotation() {
        start = currentTimeMillis();
    }

    @After("performancePointCut()")
    public void afterMethodWithPerformanceAnnotation() {
        System.out.println("execution time: " + (currentTimeMillis() - start));
    }
}
