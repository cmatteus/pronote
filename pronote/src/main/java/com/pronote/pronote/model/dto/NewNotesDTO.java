package com.pronote.pronote.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class NewNotesDTO {
	
	private Integer userId;
	private LocalDate date;
	private String status;
	private String note;
	
}