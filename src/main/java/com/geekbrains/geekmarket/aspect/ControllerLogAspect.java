package com.geekbrains.geekmarket.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    @Before("@annotation(com.geekbrains.geekmarket.aspect.BenchMark)")
    public void logBefore(JoinPoint joinPoint) {
        log.debug("{}", joinPoint);
        Object[] args = joinPoint.getArgs();
        String logMessage = joinPoint.toShortString().replaceAll("execution|\\(..\\)|\\(|\\)", "") + Arrays.stream(args)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "(",  ")"));

        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        log.debug("{}", logMessage);
    }


}
