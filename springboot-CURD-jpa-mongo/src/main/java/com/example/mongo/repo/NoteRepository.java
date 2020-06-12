package com.example.mongo.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongo.model.Note;
@Repository
public interface NoteRepository extends MongoRepository<Note, String>{

	Optional<Note> findByTitle(String title);

}
