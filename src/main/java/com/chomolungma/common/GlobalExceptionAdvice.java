/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.chomolungma.common;

import org.jboss.logging.Logger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionAdvice {

	private Logger logger = Logger.getLogger(GlobalExceptionAdvice.class);
	
	@ExceptionHandler({ AppException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultResponse appException(AppException ex) {
		logger.error(ex);
		return new ResultResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	}

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultResponse internalServerException(Exception ex) {
		logger.error(ex);
		return new ResultResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
	}
	
	
	@ExceptionHandler({NoHandlerFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResultResponse notFoundException(NoHandlerFoundException ex) {
		logger.error(ex.getMessage(),ex);
		return new ResultResponse(false, HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResultResponse notValidException(MethodArgumentNotValidException ex) {
		logger.error(ex);
		BindingResult result = ex.getBindingResult();
		List<Map<String, String>> fieldsErrors = new ArrayList<Map<String, String>>();
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			logger.error(errors);
			errors.forEach(e -> {
				Map<String, String> fieldError = new HashMap<String, String>();
				DefaultMessageSourceResolvable defaultMessage = (DefaultMessageSourceResolvable)e.getArguments()[0];
				fieldError.put("field",defaultMessage.getDefaultMessage());
				fieldError.put("message", e.getDefaultMessage());
				fieldsErrors.add(fieldError);
			});

		}
		return new ResultResponse(false, HttpStatus.BAD_REQUEST.value(), "parameter error", fieldsErrors);
	}
}
