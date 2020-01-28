package com.cursoudemy.springboot2mongodb.repository;

import java.util.List;

import com.cursoudemy.springboot2mongodb.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContainingIgnoreCase(String text);

  @Query("{'title': {$regex: ?0, $options: 'i'}}")
  List<Post> searchTitle(String string);

}
