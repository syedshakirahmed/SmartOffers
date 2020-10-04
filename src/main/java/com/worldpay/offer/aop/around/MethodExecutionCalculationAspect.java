package com.worldpay.offer.aop.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.worldpay.offer.aop.around.TrackTime)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Before "+startTime);
        joinPoint.proceed();
        logger.info("After "+System.currentTimeMillis());
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }
}
