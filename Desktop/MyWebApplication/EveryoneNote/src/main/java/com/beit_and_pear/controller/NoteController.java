package com.beit_and_pear.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.beit_and_pear.model.Note;
import com.beit_and_pear.service.NoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoteController {

	private final NoteService service;

	@GetMapping("/")
	public String getAllNotes(Model model, @PageableDefault(size = 30) Pageable pageable) {
		model.addAttribute("page", service.selectAll(pageable));

		return "list";
	}

	@GetMapping("/add")
	public String addNote(@ModelAttribute Note note) {
		return "form";
	}

	@PostMapping("/process")
	public String process(@Validated @ModelAttribute Note note, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		service.save(note);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editNote(@PathVariable Long id, Model model) {
		model.addAttribute("note", service.selectByPrimaryKey(id));
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String deleteNote(@PathVariable Long id) {
		service.deleteByPrimaryKey(id);
		return "redirect:/";
	}
}
