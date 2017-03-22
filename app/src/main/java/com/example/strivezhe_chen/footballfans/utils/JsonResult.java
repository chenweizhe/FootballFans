package com.example.strivezhe_chen.footballfans.utils;

/**
 * Created by StriveZhe_Chen on 2017/3/3.
 * 获取接送数据的类，形式按照json数据格式创建
 */

public class JsonResult<T> {
    private String reason;
    private T Data;
    private int errcode;

    public JsonResult() {
    }

    public JsonResult(String result, T data, int errcode) {
        this.reason = result;
        Data = data;
        this.errcode = errcode;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
