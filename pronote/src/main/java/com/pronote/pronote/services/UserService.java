package com.pronote.pronote.services;

import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pronote.pronote.model.dto.NewUserDTO;
import com.pronote.pronote.model.dto.UserDTO;
import com.pronote.pronote.model.entity.User;
import com.pronote.pronote.model.mapper.UserMapper;
import com.pronote.pronote.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    
    public UserDTO update(Integer user_id, NewUserDTO newUserDTO) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com o ID: " + user_id)); 
        
        user.setUsername(newUserDTO.getUsername());
        user.setEmail(newUserDTO.getEmail());
        user.setSenha(newUserDTO.getSenha());
        
        return userMapper.toUserDTO(userRepository.save(user));
    }

    public void delete(Integer user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com o ID: " + user_id));
        
        userRepository.delete(user);
    }

    public UserDTO create(NewUserDTO newUserDTO) {
        User user = userMapper.toUser(newUserDTO);
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        user = userRepository.save(user);
        return userMapper.toUserDTO(user);
    }
}

/* POSTMAN: http://localhost:8080/users

- No POST e no PUT:

{
    "username": "NovoNomeDeUsuario",
    "email": "novoemail@example.com",
    "senha": "novaSenha123"
}

- No DELETE:

http://localhost:8080/users/{ID} */

