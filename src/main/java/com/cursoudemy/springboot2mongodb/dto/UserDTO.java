package com.cursoudemy.springboot2mongodb.dto;

import java.io.Serializable;

import com.cursoudemy.springboot2mongodb.domain.User;

/**
 * UserDTO
 */
public class UserDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String email;

  public UserDTO() {
  }

  public UserDTO(User obj) {
    id = obj.getId();
    name = obj.getName();
    email = obj.getEmail();
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
