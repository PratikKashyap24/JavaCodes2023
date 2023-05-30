package com.dxc.cs.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

 

@Component
@Aspect
@Configuration
public class ResponseTimeAdvice {

 

    private Logger logger = LoggerFactory.getLogger(this.getClass());

 

    @Before("execution(* com.dxc.cs.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // advice
        
        long startTime = System.currentTimeMillis();

 

        logger.info("entering the data");
        long endTime = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature().getName() + " ExecutionDuration: " + (endTime - startTime) + "ms");

 

        logger.info("Allowed execution for", joinPoint);
    }
}