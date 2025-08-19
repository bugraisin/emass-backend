package com.emass.emass_backend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.emass.emass_backend.service..*(..))")
    public void logBefore(JoinPoint jp) {
        String args = Arrays.toString(jp.getArgs());
        if (args.length() > 500) args = args.substring(0, 500) + "...";
        log.info("→ Enter {} args={}", jp.getSignature().toShortString(), args);
    }

    @AfterReturning(pointcut = "execution(public * com.emass.emass_backend.service..*(..))",
            returning = "result")
    public void logAfter(JoinPoint jp, Object result) {
        String out;
        if (result instanceof Collection<?> c) out = "Collection(size=" + c.size() + ")";
        else out = String.valueOf(result);
        if (out.length() > 500) out = out.substring(0, 500) + "...";
        log.info("← Exit  {} return={}", jp.getSignature().toShortString(), out);
    }

    @AfterThrowing(pointcut = "execution(public * com.emass.emass_backend.service..*(..))",
            throwing = "ex")
    public void logException(JoinPoint jp, Throwable ex) {
        log.error("✖ Error in {}: {}", jp.getSignature().toShortString(), ex.toString(), ex);
    }
}
