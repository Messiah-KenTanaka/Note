package com.beit_and_pear.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beit_and_pear.model.MUser;
import com.beit_and_pear.model.Note;
import com.beit_and_pear.service.NoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoteController {

	private final NoteService service;

	@GetMapping("/list")
	public String getAllNotes(Authentication loginUser, Model model, MUser user,
			@PageableDefault(size = 20) Pageable pageable) {
		model.addAttribute("page", service.selectAll(pageable));
		model.addAttribute("userid", loginUser.getName());
		return "list";
	}

	@GetMapping("/add")
	public String addNote(@ModelAttribute Note note) {
		return "form";
	}

	@PostMapping("/process")
	public String process(Authentication loginUser, @Validated @ModelAttribute Note note, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("agein", "もう一度入力してください");
			return "form";
		}
		String userId = loginUser.getName();
		note.setUserId(userId);
		// 現在日付をnoteに格納
		note.setDate(LocalDate.now());
		service.save(note);

		redirectAttributes.addFlashAttribute("add", "追加しました");

		return "redirect:/list";
	}

	@GetMapping("/edit/{id}")
	public String editNote(@PathVariable Long id, Model model) {
		model.addAttribute("note", service.selectByPrimaryKey(id));
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String deleteNote(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		service.deleteByPrimaryKey(id);
		redirectAttributes.addFlashAttribute("delete", "削除しました");
		return "redirect:/list";
	}
}
