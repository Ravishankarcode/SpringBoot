package com.example.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notes.model.Note;

/**
 * 
 * @author Ravishankar.kumar
 *
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
