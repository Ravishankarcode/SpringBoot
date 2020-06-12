package com.example.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.exception.ResourceNotFoundException;
import com.example.mongo.model.Note;
import com.example.mongo.repo.NoteRepository;


@RestController
@RequestMapping("/api")
public class NoteController {


    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{title}")
    public Note getNoteByTitle(@PathVariable(value = "title") String title) {
        return noteRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "title", title));
    }

    @PutMapping("/notes/{title}")
    public Note updateNote(@PathVariable(value = "title") String title,
                                           @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "title", title));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{title}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "title") String title) {
        Note note = noteRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "title", title));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
