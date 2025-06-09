package com.pronote.pronote.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.pronote.pronote.model.dto.NewUserDTO;
import com.pronote.pronote.model.dto.UserDTO;
import com.pronote.pronote.model.entity.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
	
private final ModelMapper modelMapper;
	
	public User toUser(NewUserDTO newUserDTO) {
		return  User.builder()
				.username(newUserDTO.getUsername())
				.email(newUserDTO.getEmail())
				.senha(newUserDTO.getSenha())
				.build();
	}
	
	public UserDTO toUserDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

}
