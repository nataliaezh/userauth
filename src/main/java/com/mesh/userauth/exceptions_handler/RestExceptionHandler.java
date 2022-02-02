package com.mesh.userauth.exceptions_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleRNFException (ResourceNotFoundException exc){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setMessage(exc.getMessage());
		exceptionResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
