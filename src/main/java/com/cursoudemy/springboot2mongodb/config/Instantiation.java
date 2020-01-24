package com.cursoudemy.springboot2mongodb.config;

import java.util.Arrays;

import com.cursoudemy.springboot2mongodb.domain.User;
import com.cursoudemy.springboot2mongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Instantiation
 */
@Configuration
public class Instantiation implements CommandLineRunner {

  private UserRepository repository;

  @Autowired
  public Instantiation(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    repository.saveAll(Arrays.asList(maria, alex, bob));

  }

}
