package com.cursoudemy.springboot2mongodb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cursoudemy.springboot2mongodb.domain.User;
import com.cursoudemy.springboot2mongodb.dto.UserDTO;
import com.cursoudemy.springboot2mongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * DTOs são geralmente usados para previnir uma queda de desempenho que uma
     * transferencia de um objeto muito grande pode causar através da rede. Em um
     * contexto local e pequeno, eles não são necessarios, pelo contrário, apenas
     * aumentam a complexidade da aplicação, seu uso aqui resume-se apenas a um
     * exemplo.
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = service.findAll();
        List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = service.getById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User userEntity = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userEntity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userEntity);
    }
}
