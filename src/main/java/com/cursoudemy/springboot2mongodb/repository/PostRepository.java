package com.cursoudemy.springboot2mongodb.repository;

import com.cursoudemy.springboot2mongodb.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
