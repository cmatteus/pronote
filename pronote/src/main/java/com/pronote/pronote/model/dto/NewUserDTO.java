package com.pronote.pronote.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class NewUserDTO {
	
	private String username;
	private String email;
	private String senha;
	
}