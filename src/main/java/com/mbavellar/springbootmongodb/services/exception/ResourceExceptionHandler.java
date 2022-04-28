package com.mbavellar.springbootmongodb.services.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @SuppressWarnings("static-method")
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError error = new StandardError(
        System.currentTimeMillis(),
        status.value(), 
        "Not Found!",
        e.getMessage(), 
        request.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }
}
