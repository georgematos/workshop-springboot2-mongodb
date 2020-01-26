package com.cursoudemy.springboot2mongodb.service;

import java.util.List;
import java.util.Optional;

import com.cursoudemy.springboot2mongodb.domain.User;
import com.cursoudemy.springboot2mongodb.repository.UserRepository;
import com.cursoudemy.springboot2mongodb.service.exception.ObjectNotFoundException;

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

    public User insert(User user) {
        User newUser = repository.insert(user);
        return newUser;
    }

    public User findById(String id) {
        Optional<User> userOptinal = repository.findById(id);
        // orElseThrow: retorna o objeto contido, se não, lança a exceção fornecida pela função anônima.
        return userOptinal.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
