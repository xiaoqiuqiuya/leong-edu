package com.leong.result;

/**
 * @author Leong
 * @description
 * @createDate 2020/10/24 20:30
 * @updateDate 2020/10/24 20:30
 **/
public interface ResultCode {
    int OK = 20000; //成功
    int ERROR = 20001;  //失败
    int SQL_ERROR = 20006; //sql异常
}
