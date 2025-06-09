package com.pronote.pronote.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserDTO {
	
	private Integer user_id;
	private String username;
	private String email;
	private String senha;
	
}