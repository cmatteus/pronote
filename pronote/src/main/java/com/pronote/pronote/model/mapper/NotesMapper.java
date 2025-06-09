package com.pronote.pronote.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pronote.pronote.model.dto.NewNotesDTO;
import com.pronote.pronote.model.dto.NotesDTO;
import com.pronote.pronote.model.entity.Notes;
import com.pronote.pronote.model.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotesMapper {
	
private final ModelMapper modelMapper;
	
	public Notes toNotes(NewNotesDTO newNotesDTO) {
		
		User u = new User();
		u.setId(newNotesDTO.getUserId());
		return  Notes.builder()
				.user(u)
				.date(newNotesDTO.getDate())
				.status(newNotesDTO.getStatus())
				.note(newNotesDTO.getNote())
				.build();
	}
	
	public NotesDTO toNotesDTO(Notes notes) {
		
		var notesDTO = modelMapper.map(notes, NotesDTO.class);
		notesDTO.setUser_id(notes.getUser().getId());
		return notesDTO;
	}

}
