package com.chomolungma.common.result;

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
        return new Result("操作成功！",200,null);
    }
    public static Result success( Object data){
        return new Result("操作成功！",200,data);
    }

    public static Result success(String msg, Object data){
            return new Result(msg,200,data);
    }

    public static Result fail(Object data){
        return new Result("操作失败",500,data);
    }

    public static Result fail(String msg, Object data){
        return new Result(msg,500,data);
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
