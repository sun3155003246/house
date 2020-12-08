package com.sxp.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * Description:接口返回前端通用json格式数据
 */
@Data
public class ApiResponse {

    private int code;
    private String message;
    private Object data;

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse ofSuccess(Object data){
        return new ApiResponse(Status.SUCCESS.code,Status.SUCCESS.message,data);
    }

    public static ApiResponse ofErrorMessage(int code,String message){
        return new ApiResponse(code,message,null);
    }

    public enum Status{
        SUCCESS(200,"success"),
        PARAMS_NULL(10000,"params is null"),
        RESULT_NULL(10001,"result is null"),
        BAD_REQUST(10002,"bad request");

        @Getter
        @Setter
        private int code;
        @Getter
        @Setter
        private String message;
        Status(int code, String message){

            this.code = code;
            this.message = message;
        }

    }
}
