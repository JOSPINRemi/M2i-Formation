package org.example.library_management.apect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("@annotation(org.example.library_management.annotation.LoggingAnnotation)")
    public void loggingAnnotationPointCut() {
    }

    @Before("loggingAnnotationPointCut()")
    public void beforeMethodWithLoggingAnnotation(JoinPoint joinPoint) {
        System.out.println("method name: " + joinPoint.getSignature().getName() + " and method params: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "loggingAnnotationPointCut()", returning = "result")
    public void afterMethodWithLoggingAnnotation(Object result) {
        System.out.println("method result: " + result);
    }
}
