package com.cursoudemy.springboot2mongodb.repository;

import java.util.Date;
import java.util.List;

import com.cursoudemy.springboot2mongodb.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  // findBy<nomeDoAtributo>ContainingIgnoreCase
  List<Post> findByTitleContainingIgnoreCase(String text);

  // ?0 é o primeiro parametro da função, a string no caso
  @Query("{'title': {$regex: ?0, $options: 'i'}}")
  List<Post> searchTitle(String string);

  @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
  List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
