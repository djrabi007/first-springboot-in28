package com.in28minutes.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.in28minutes.springboot.model.ErrorMessage;
import com.in28minutes.springboot.model.UserException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	String ERROR_MESSAGE="URI path is not acceptable!!";
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(Exception.class)
	public ErrorMessage handleException() {
		return new ErrorMessage("406", ERROR_MESSAGE);
	}
	
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(UserException.class)
	public ErrorMessage handleCustomException() {
		return new ErrorMessage("420", "User Not Found");
	}

}
