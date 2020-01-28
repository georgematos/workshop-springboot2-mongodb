package com.cursoudemy.springboot2mongodb.service;

import java.util.Date;
import java.util.List;

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

  public List<Post> findByTitle(String text) {
    return repository.searchTitle(text);
  }

  public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
    maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
    return repository.fullSearch(text, minDate, maxDate);
  }
}
