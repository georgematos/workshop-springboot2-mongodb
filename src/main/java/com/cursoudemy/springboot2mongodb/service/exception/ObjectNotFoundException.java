package com.cursoudemy.springboot2mongodb.service.exception;

/**
 * ObjectNotFoundException
 */
public class ObjectNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ObjectNotFoundException(String msg) {
    super(msg);
  }

}
