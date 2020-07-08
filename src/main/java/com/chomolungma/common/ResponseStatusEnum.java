/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.chomolungma.common;


public enum ResponseStatusEnum {


    FAIL(false,"请求失败！"),
    SUCCESS(true,"请求成功！");

    private boolean status;
    private String msg;

    ResponseStatusEnum(boolean status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
