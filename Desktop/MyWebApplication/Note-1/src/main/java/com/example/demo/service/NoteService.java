package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Note;

public interface NoteService {

	void create(Note note);

	void update(Note note);

	void deleteById(int id);

	List<Note> getAll();

	Optional<Note> getNote(int id);

}
