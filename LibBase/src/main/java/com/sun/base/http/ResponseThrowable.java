package com.sun.base.http;

/**
 * @author: Harper
 * @date: 2022/9/8
 * @note:
 */
public class ResponseThrowable extends Exception {
    public int code;
    public String message;

    public ResponseThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
