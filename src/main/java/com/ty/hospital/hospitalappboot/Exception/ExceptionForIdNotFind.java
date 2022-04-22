package com.ty.hospital.hospitalappboot.Exception;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionForIdNotFind extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoFoundByIdException.class)
	public ResponseEntity<String> handleNoIdFoundException(NoFoundByIdException idFoundException){
		String message = idFoundException.getMessage();
		ResponseEntity<String> entity = new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		return entity;
	}

}
