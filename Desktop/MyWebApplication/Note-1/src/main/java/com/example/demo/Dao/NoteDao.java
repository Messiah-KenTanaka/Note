package com.example.demo.Dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Note;

public interface NoteDao {

	void create(Note note);

	int update(Note note);

	int deleteById(int id);

	List<Note> getAll();

	Optional<Note> findById(int id);

}
