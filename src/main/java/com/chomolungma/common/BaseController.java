/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.chomolungma.common;

import org.springframework.http.HttpStatus;

public class BaseController {



    protected static ResultResponse success(){
        return new ResultResponse(ResponseStatusEnum.SUCCESS.isStatus(),HttpStatus.OK.value(),ResponseStatusEnum.SUCCESS.getMsg());
    }



    protected static ResultResponse success(Object data){
        return new ResultResponse(ResponseStatusEnum.SUCCESS.isStatus(),HttpStatus.OK.value(),ResponseStatusEnum.SUCCESS.getMsg(),data);
    }
    
    
    protected static ResultResponse fail() {
    	return new ResultResponse(ResponseStatusEnum.FAIL.isStatus(),HttpStatus.INTERNAL_SERVER_ERROR.value(),ResponseStatusEnum.SUCCESS.getMsg());
    }
}
