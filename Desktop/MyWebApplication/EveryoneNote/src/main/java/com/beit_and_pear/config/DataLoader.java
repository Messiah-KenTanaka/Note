package com.beit_and_pear.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.beit_and_pear.model.Note;
import com.beit_and_pear.service.NoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

	private final NoteService service;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
			Note note = new Note();
			note.setName("テスト");
			note.setContent("テストです。削除して使用してください。");
			service.save(note);
		}
	}

}
