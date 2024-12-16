package com.example.demospringelasticsearch.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LogginAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogginAspect.class);

    @Before("execution(* com.example.demospringelasticsearch.service.*.*(..))")
    public void logBeforeMethods(JoinPoint joinPoint) {
        logger.info("Method {} is started.", joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.demospringelasticsearch.service.*.*(..))")
    public void logAfterMethods(JoinPoint joinPoint) {
        logger.info("Method {} is end.", joinPoint.getSignature().getName());
    }
}
