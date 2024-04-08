package com.student.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;

	@ControllerAdvice
	@RestControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleGlobalException(Exception ex) {
	        // Log the exception here if needed
	        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ExceptionHandler(IllegalStateException.class)
	    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
	        // Log the exception here if needed
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	   

	}



