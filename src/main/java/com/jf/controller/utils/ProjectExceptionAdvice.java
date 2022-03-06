package com.jf.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public R doException(Exception exception) {
        exception.printStackTrace();
        return new R(false,"服务器故障，请稍后再试！");
    }
}
