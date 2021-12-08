package com.codegym.library.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDateTime;

@Aspect
public class BookLog {
    @AfterReturning(pointcut = "execution(public * com.codegym.library.service.BookService.save(..))")
    public void log() {
        System.out.println("[Log 1] -- Trạng thái sách thay đổi lúc " + LocalDateTime.now());
    }
}
