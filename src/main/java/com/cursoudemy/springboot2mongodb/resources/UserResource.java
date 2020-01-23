package com.cursoudemy.springboot2mongodb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.cursoudemy.springboot2mongodb.domain.User;
import com.cursoudemy.springboot2mongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private UserService service;

    @Autowired
    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = new ArrayList<>();
        users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User userEntity = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userEntity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userEntity);
    }
}
