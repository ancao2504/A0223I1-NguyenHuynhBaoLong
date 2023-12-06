package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ChangeAspect {
    private Logger logger = Logger.getLogger(ChangeAspect.class.getName());

    @Pointcut("execution (* com.example.service.IBookService.*(..))")
    public void bookService(){}

    @Before("bookService()")
    public void writeLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("=======before======"+ methodName);
    }
}
