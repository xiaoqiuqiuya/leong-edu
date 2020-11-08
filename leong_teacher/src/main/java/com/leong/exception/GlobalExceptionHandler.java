package com.leong.exception;

import com.leong.result.Result;
import com.leong.result.ResultCode;
import com.leong.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Leong
 * @description
 * @createDate 2020/10/25 10:43
 * @updateDate 2020/10/25 10:43
 **/

/*
    全局异常处理器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常类型 Exception
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().message("出错了");
    }

    // SQL异常 BadSqlGrammarException
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public Result error(BadSqlGrammarException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().code(ResultCode.SQL_ERROR).message("SQL语法错误");
    }

    // 自定义异常 EduException
    @ExceptionHandler(EduException.class)
    @ResponseBody
    public Result error(EduException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().code(e.getCode()).message(e.getMsg());
    }


}
