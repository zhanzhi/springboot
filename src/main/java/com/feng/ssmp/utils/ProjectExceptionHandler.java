package com.feng.ssmp.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler//处理所有的异常
    public R doException(Exception ex){
        ex.printStackTrace();
        return new R(false,"服务器故障！");
    }
}
