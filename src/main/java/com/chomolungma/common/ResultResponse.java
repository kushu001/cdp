/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.chomolungma.common;

import java.util.Date;

public class ResultResponse {

    private Date time;

    private boolean success;

    private int code;

    private String message;

    private Object data;

    ResultResponse(boolean success, int code, String message, Object data){
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    ResultResponse(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Date getTime() {
        return new Date();
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "time=" + time +
                ", success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
