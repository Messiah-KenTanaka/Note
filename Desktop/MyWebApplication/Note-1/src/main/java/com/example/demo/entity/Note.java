package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {
	private int id;
	private LocalDateTime dateTime;
	private String title;
	private String name;
	private String contents;
}
