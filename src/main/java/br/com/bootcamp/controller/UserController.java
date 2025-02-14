package br.com.bootcamp.controller;

import br.com.bootcamp.dto.user.UserCreateDTO;
import br.com.bootcamp.dto.user.UserResponseDTO;
import br.com.bootcamp.entity.User;
import br.com.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") String uuid) {
        return ResponseEntity.ok(new UserResponseDTO(userService.findById(uuid)));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userRequest) {
        User user = userService.create(userRequest);
        var userResponse = new UserResponseDTO(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(userResponse);
    }
}
