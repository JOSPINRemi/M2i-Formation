package org.example.demo_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {
    /**
     * "* org.example.demo_aop.service.*.*(..)"
     * => la totalité des méthodes des classes du package service avec n'importe quel argument
     */
    /*@Before("execution(* org.example.demo_aop.service.*.*(..))")
    public void addActionBefore() {
        System.out.println("Action executed Before by Aspect");
    }

    @After("execution(* org.example.demo_aop.service.*.*(..))")
    public void addActionAfter() {
        System.out.println("Action executed After by Aspect");
    }

    @AfterReturning("execution(* org.example.demo_aop.service.*.*(..))")
    public void addActionAfterReturning() {
        System.out.println("Action executed AfterReturning value by Aspect");
    }

    @AfterThrowing("execution(* org.example.demo_aop.service.*.*(..))")
    public void addActionAfterThrowing() {
        System.out.println("Action executed AfterThrowing exception by Aspect");
    }*/
    @Around("execution(* org.example.demo_aop.service.*.*(..))")
    public void addActionAround(ProceedingJoinPoint joinPoint) {
        try {
//            Avant
            System.out.println("Start Around");
//            Execute
            joinPoint.proceed();
        } catch (Exception e) {
//            Après
            System.out.println("End Around");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Pointcut("@annotation(org.example.demo_aop.annotation.CustomAnnotation)")
    public void customAnnotationPointCut() {

    }

    @Before("customAnnotationPointCut()")
    public void methodAspectWithAnnotation() {
        System.out.println("Aspect run before method with annotation");
    }
}
