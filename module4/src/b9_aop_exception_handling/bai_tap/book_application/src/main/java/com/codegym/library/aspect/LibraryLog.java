package com.codegym.library.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LibraryLog {
    private static int action;

    @AfterReturning(pointcut = "execution(public * com.codegym.library.service.*.*(..))")
    public void log() {
        action++;
        System.out.println("[Log 2] -- Số lượng truy cập thư viện: " + action);
    }
}
