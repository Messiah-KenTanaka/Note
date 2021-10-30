package com.beit_and_pear.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beit_and_pear.mapper.NoteMapper;
import com.beit_and_pear.model.Note;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class NoteService {

	private final NoteMapper mapper;

	// Pageableを追加
	public Page<Note> selectAll(Pageable pageable) {
		RowBounds rowBounds = new RowBounds((int) pageable.getOffset(), pageable.getPageSize());
		List<Note> notes = mapper.selectAll(rowBounds);

		Long total = mapper.count();
		return new PageImpl<Note>(notes, pageable, total);
	}

	public List<Note> selectAll() {
		return mapper.selectAll();
	}

	public Note selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public void save(Note note) {
		if (note.getId() == null) {
			mapper.insert(note);
		} else {
			mapper.updateByPrimaryKey(note);
		}
	}

	public void deleteByPrimaryKey(Long id) {
		mapper.deleteByPrimaryKey(id);
	}
}
