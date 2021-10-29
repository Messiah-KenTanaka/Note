package com.beit_and_pear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beit_and_pear.model.Note;

@Mapper
public interface NoteMapper {

	List<Note> selectAll();

	Note selectByPrimaryKey(Long id);

	int insert(Note note);

	int updateByPrimaryKey(Note note);

	int deleteByPrimaryKey(Long id);
}
