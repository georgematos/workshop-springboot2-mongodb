package com.cursoudemy.springboot2mongodb.service;

import com.cursoudemy.springboot2mongodb.domain.Post;
import com.cursoudemy.springboot2mongodb.repository.PostRepository;
import com.cursoudemy.springboot2mongodb.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private PostRepository repository;

  public PostService() {
  }

  @Autowired
  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public Post findById(String id) {
    return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("O objeto não pode ser encontrado"));
  }
}
