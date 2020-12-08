package com.sxp.utils;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/11/8 10:55
 * @Description: 接口的返回值封装对象---只应用于写操作
 */
@Data
public class ServiceResult<T> {

    private boolean success;
    private String message;
    private T result;

    public ServiceResult(boolean success) {
        this.success = success;
    }

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ServiceResult(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }
}
