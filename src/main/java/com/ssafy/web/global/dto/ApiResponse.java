package com.ssafy.web.global.dto;

public class ApiResponse<T> {
    private int code;
    private String msg;
    private T data;

    public void ok(String msg, T data){
        this.code = 200;
        this.msg = msg;
        this.data = data;
    }

    public void fail(String msg, T data){
        this.code = 400;
        this.msg = msg;
        this.data = data;
    }
}
