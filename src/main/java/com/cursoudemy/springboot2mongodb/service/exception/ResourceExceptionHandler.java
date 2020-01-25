package com.cursoudemy.springboot2mongodb.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest resquest) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError stdErr = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não pode ser encontrado",
        exception.getMessage(), resquest.getRequestURI());

    return ResponseEntity.status(status).body(stdErr);
  }

}
