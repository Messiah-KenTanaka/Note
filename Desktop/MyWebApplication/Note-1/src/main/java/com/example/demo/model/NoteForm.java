package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dateTime;

	@Size(max = 20, message = "20文字以内で入力してください")
	private String name;

	@Size(max = 30, message = "30文字以内で入力してください")
	private String title;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 500, message = "500文字以内で入力してください")
	private String contents;
}
