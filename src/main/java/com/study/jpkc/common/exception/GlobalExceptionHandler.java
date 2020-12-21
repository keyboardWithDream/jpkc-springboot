package com.study.jpkc.common.exception;

import com.study.jpkc.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/12/21
 * @desc 全局异常处理
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ShiroException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result authenticationTest(ShiroException e) {
        log.warn("Shiro警告 ====>> " + e.getMessage());
        return Result.getFailRes(401, e.getMessage());
    }

    /**
     * 处理Assert的异常
     * @param e 异常
     * @return 返回
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result illegalArgumentException(IllegalArgumentException e) {
        log.warn("Assert警告 ====>> " + e.getMessage());
        return Result.getFailRes(e.getMessage());
    }

    /**
     * 数据绑定校验异常
     * @param e 异常
     * @return 返回
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result bindException(BindException e) {
        List<ObjectError> allErrors = e.getAllErrors();
        ObjectError error = allErrors.get(0);
        log.warn("数据绑定校验警告 ====>> " + error.getDefaultMessage());
        return Result.getFailRes(error.getDefaultMessage());
    }

}