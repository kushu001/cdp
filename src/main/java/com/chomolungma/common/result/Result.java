package com.chomolungma.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Result {
    private String msg;
    private int code;
    private Object data;

    public Result(String msg, int code, Object data){
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static Result success( ){
        return new Result("操作成功！",HttpStatus.OK.value(),null);
    }
    public static Result success( Object data){
        return new Result("操作成功！",HttpStatus.OK.value(),data);
    }

    public static Result success(String msg, Object data){
            return new Result(msg,HttpStatus.OK.value(),data);
    }

    public static Result fail(Object data){
        return new Result("操作失败",HttpStatus.INTERNAL_SERVER_ERROR.value(),data);
    }

    public static Result fail(String msg, Object data){
        return new Result(msg,HttpStatus.INTERNAL_SERVER_ERROR.value(),data);
    }

    public static Result fail(String msg, HttpStatus status, Object data){
        return new Result(msg,status.value(),data);
    }

    public static Result fail(String msg, HttpStatus status){
        return new Result(msg,status.value(),null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
