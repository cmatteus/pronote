package com.pronote.pronote.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pronote.pronote.model.dto.NewUserDTO;
import com.pronote.pronote.model.dto.UserDTO;
import com.pronote.pronote.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody NewUserDTO user) {
        UserDTO userCriado = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userCriado);
    }
    
    @PutMapping("/{user_id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer user_id, @RequestBody NewUserDTO user) {
        UserDTO userAtualizado = userService.update(user_id, user);
        return ResponseEntity.ok(userAtualizado);
    }
    
    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable Integer user_id) {
        userService.delete(user_id);
        return ResponseEntity.noContent().build();
    }
}

