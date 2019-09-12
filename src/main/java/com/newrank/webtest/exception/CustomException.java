package com.newrank.webtest.exception;

import lombok.Data;

/**
 * @program: webtest
 * @description: 自定义异常
 * @author: ren
 * @create: 2019-06-21 14:23
 **/
@Data
public class CustomException extends Exception {
    private int code;
    private String msg;

    public CustomException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
