package com.pronote.pronote.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pronote.pronote.model.dto.NewNotesDTO;
import com.pronote.pronote.model.dto.NotesDTO;
import com.pronote.pronote.services.NotesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {
    
    private final NotesService notesService;
    
    @PostMapping
    public ResponseEntity<NotesDTO> create(@RequestBody NewNotesDTO notes) {
        NotesDTO notesCriado = notesService.create(notes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(notesCriado);
    }
    
    @PutMapping("/{note_id}")
    public ResponseEntity<NotesDTO> update(@PathVariable Integer notes_id, @RequestBody NewNotesDTO notes) {
        NotesDTO notesAtualizado = notesService.update(notes_id, notes);
        return ResponseEntity.ok(notesAtualizado);
    }
    
    @DeleteMapping("/{notes_id}")
    public ResponseEntity<Void> delete(@PathVariable Integer note_id) {
        notesService.delete(note_id);
        return ResponseEntity.noContent().build();
    }
}

