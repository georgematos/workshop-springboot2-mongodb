package com.cursoudemy.springboot2mongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.cursoudemy.springboot2mongodb.domain.Post;
import com.cursoudemy.springboot2mongodb.domain.User;
import com.cursoudemy.springboot2mongodb.dto.UserDTO;
import com.cursoudemy.springboot2mongodb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO userDto = new UserDTO(service.findById(id));
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = service.findById(id);
        List<Post> posts = user.getPosts();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/{id}/posts/{pid}")
    public ResponseEntity<Post> getPostById(@PathVariable String id, @PathVariable String pid) {

        User user = service.findById(id);
        List<Post> post = user.getPosts().stream().filter(x -> x.getId().equals(pid)).collect(Collectors.toList());

        return ResponseEntity.ok().body(post.get(0));

    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User userEntity = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userEntity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User userUpdated = service.update(user);
        return ResponseEntity.ok().body(userUpdated);
    }
}
