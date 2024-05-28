package com.tiger.common.utils;

import cn.hutool.core.util.StrUtil;
/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 11:15
 * @Remark:
 */

public class Response {

    //消息代码
    private Integer code;
    //数据
    private Object data;
    //接口返回提示
    private String message;

    public static Response of(int code){
        return new Response(code);
    }

    public static Response of(Object data){
        return new Response(data);
    }

    public static Response of(int code, String message){
        return new Response(code, null, message);
    }

    public Response(int code){
        this(code, null, null);
    }

    public Response(Object data){
        this(1, data, null);
    }

    public Response(int code, String message){
        this(1, null, message);
    }

    public Response(int code, Object data, String message){
        this.code = code;
        this.data = data;

        if (this.code <= 0) {
            this.message = StrUtil.isEmpty(message) ? "ERROR" : message;
        } else {
            this.message = "Success";
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
