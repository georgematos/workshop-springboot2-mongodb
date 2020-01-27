package com.cursoudemy.springboot2mongodb.resources;

import java.util.List;

import com.cursoudemy.springboot2mongodb.domain.Post;
import com.cursoudemy.springboot2mongodb.resources.util.URL;
import com.cursoudemy.springboot2mongodb.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/posts")
public class PostResource {

  private PostService service;

  public PostResource() {
  }

  @Autowired
  public PostResource(PostService service) {
    this.service = service;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    return ResponseEntity.ok().body(service.findById(id));
  }

  @GetMapping(value = "/titlesearch")
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
    text = URL.decodeParam(text);
    List<Post> list = service.findByTitle(text);
    return ResponseEntity.ok().body(list);
  }

}
