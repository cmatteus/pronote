package com.pronote.pronote.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class NotesDTO {
	
	private Integer note_id;
	private Integer user_id;
	private LocalDate date;
	private String status;
	private String note;
	
}