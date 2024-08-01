package com.emass.aspect;

import com.emass.location.city.City;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* com.emass.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Started: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.emass.service..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Returning: " + joinPoint.getSignature().getName());
    }
}
