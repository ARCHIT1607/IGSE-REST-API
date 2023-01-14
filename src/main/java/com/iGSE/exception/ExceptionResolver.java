package com.iGSE.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler
    public ResponseEntity<Object> handleAccessDeniedException(CustomException e, HttpServletRequest request){
    	return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
