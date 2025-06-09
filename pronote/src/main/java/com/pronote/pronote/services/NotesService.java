package com.pronote.pronote.services;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.pronote.pronote.model.dto.NewNotesDTO;
import com.pronote.pronote.model.dto.NotesDTO;
import com.pronote.pronote.model.entity.Notes;
import com.pronote.pronote.model.entity.User;
import com.pronote.pronote.model.mapper.NotesMapper;
import com.pronote.pronote.repository.NotesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotesService {
    
    private final NotesRepository notesRepository;
    private final NotesMapper notesMapper;
    
    public NotesDTO update(Integer note_id, NewNotesDTO newNotesDTO) {
        Notes notes = notesRepository.findById(note_id)
                .orElseThrow(() -> new NoSuchElementException("Nota não encontrada com o ID: " + note_id)); 
        
        User u = new User();
		u.setId(newNotesDTO.getUserId());
        notes.setUser(u);
        notes.setDate(newNotesDTO.getDate());
        notes.setStatus(newNotesDTO.getStatus());
        notes.setNote(newNotesDTO.getNote());
        
        return notesMapper.toNotesDTO(notesRepository.save(notes));
    }

    public void delete(Integer note_id) {
        Notes notes = notesRepository.findById(note_id)
                .orElseThrow(() -> new NoSuchElementException("Nota não encontrada com o ID: " + note_id));
        
        notesRepository.delete(notes);
    }

    public NotesDTO create(NewNotesDTO newNotesDTO) {
        Notes notes = notesMapper.toNotes(newNotesDTO);
        notes = notesRepository.save(notes);
        return notesMapper.toNotesDTO(notes);
    }
}

/* POSTMAN: http://localhost:8080/notes

- No POST e no PUT:


{
    "userId": "5",
	"date": "03/06/2025",
	"status": "OK",
	"note": "Teste"
}


- No DELETE:

http://localhost:8080/users/{ID} */

