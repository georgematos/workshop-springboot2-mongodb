package com.cursoudemy.springboot2mongodb.repository;

import com.cursoudemy.springboot2mongodb.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
