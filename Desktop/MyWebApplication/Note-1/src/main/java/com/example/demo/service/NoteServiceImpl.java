package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.NoteDao;
import com.example.demo.entity.Note;

@Service // DIコンテナで自動でシングルトンとしてインスタンス化される
public class NoteServiceImpl implements NoteService {

	private final NoteDao dao;

	@Autowired
	public NoteServiceImpl(NoteDao dao) {
		this.dao = dao;
	}

	@Override
	public void create(Note note) {
		// Noteを新規作成
		dao.create(note);
	}

	@Override
	public void update(Note note) {
		// Noteを更新 idがなければ例外発生
		if (dao.update(note) == 0) {
			throw new NoteNotFoundException("更新するノートが存在しません");
		}

	}

	@Override
	public void deleteById(int id) {
		// Noteを削除 idがなければ例外発生
		if (dao.deleteById(id) == 0) {
			throw new NoteNotFoundException("削除するノートが存在しません");
		}
	}

	@Override
	public List<Note> getAll() {
		// Noteを全件取得
		return dao.getAll();
	}

	@Override
	public Optional<Note> getNote(int id) {
		// 一件を取得 idがなければ例外処理
		try {
			return dao.findById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoteNotFoundException("指定されたノートが存在しません");
		}
	}

}
