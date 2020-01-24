package com.cursoudemy.springboot2mongodb.services;

import java.util.List;
import java.util.Optional;

import com.cursoudemy.springboot2mongodb.domain.User;
import com.cursoudemy.springboot2mongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        User newUser = repository.save(user);
        return newUser;
    }

    public User getById(String id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

}
