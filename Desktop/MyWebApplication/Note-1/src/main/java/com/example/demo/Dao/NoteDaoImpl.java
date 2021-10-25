package com.example.demo.Dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Note;

@Repository
public class NoteDaoImpl implements NoteDao {
	// データベース操作用のクラス
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public NoteDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Note note) {
		jdbcTemplate.update("INSERT INTO note(dateTime, title, name, contents) values(?,?,?,?)", note.getDateTime(),
				note.getTitle(), note.getName(), note.getContents());
	}

	@Override
	public int update(Note note) {
		return jdbcTemplate.update("UPDATE note SET dateTime = ?, name = ?, title = ?, contents = ? WHERE id = ?",
				note.getDateTime(), note.getName(), note.getTitle(), note.getContents(), note.getId());
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM note WHERE id = ?", id);
	}

	@Override
	public List<Note> getAll() {
		String sql = "SELECT id, dateTime, name, title, contents FROM note　ORDER BY id DESC";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Note> list = new ArrayList<Note>();
		for (Map<String, Object> result : resultList) {
			Note note = new Note();
			note.setId((int) result.get("id"));
			note.setDateTime(((Timestamp) result.get("dateTime")).toLocalDateTime());
			note.setName((String) result.get("name"));
			note.setTitle((String) result.get("title"));
			note.setContents((String) result.get("contents"));
			list.add(note);
		}
		return list;
	}

	@Override
	public Optional<Note> findById(int id) {
		String sql = "SELECT id, dateTime, name, title, contents FROM note WHERE id = ?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);

		Note note = new Note();
		note.setId((int) result.get("id"));
		note.setDateTime(((Timestamp) result.get("dateTime")).toLocalDateTime());
		note.setName((String) result.get("name"));
		note.setTitle((String) result.get("title"));
		note.setContents((String) result.get("contents"));

		// NoteをOptionalでラップする
		Optional<Note> noteOpt = Optional.ofNullable(note);

		return noteOpt;
	}

}
