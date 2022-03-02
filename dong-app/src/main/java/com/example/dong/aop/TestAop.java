package com.example.dong.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 5:07 PM
 *
 */
@Aspect
@Component
@Slf4j
public class TestAop {

    @Around("execution(* com.example.dong.service.UserServiceImpl.test())")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("执行Service方法前");
        pjp.proceed();
        log.info("执行Service方法后");
    }

}
