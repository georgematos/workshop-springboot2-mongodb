package com.cursoudemy.springboot2mongodb.dto;

import java.io.Serializable;

import com.cursoudemy.springboot2mongodb.domain.User;

public class AuthorDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String name;

  public AuthorDTO() {
  }

  public AuthorDTO(User user) {
    id = user.getId();
    name = user.getName();
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
