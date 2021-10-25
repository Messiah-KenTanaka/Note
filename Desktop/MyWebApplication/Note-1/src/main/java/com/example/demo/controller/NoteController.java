package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Note;
import com.example.demo.model.NoteForm;
import com.example.demo.service.NoteService;

@Controller
public class NoteController {

	private final NoteService noteService;

	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	@GetMapping("/layout")
	public String layout(@ModelAttribute("add") String add, NoteForm noteForm, Model model) {
		List<Note> list = noteService.getAll();

		model.addAttribute("noteList", list);
		model.addAttribute("title", "Note");
		return "layout";
	}

	@PostMapping("/sub/create")
	public String layoutBack(@Validated NoteForm noteForm, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("title", "新規作成２");
			model.addAttribute("again", "もう一度");
			return "/sub/create";
		}
		Note note = new Note();
		note.setDateTime(LocalDateTime.now());
		note.setName(noteForm.getName());
		note.setTitle(noteForm.getTitle());
		note.setContents(noteForm.getContents());

		noteService.create(note);
		redirectAttributes.addFlashAttribute("add", "追加しました");
		return "redirect:/layout";
	}

	@GetMapping("/sub/create")
	public String create(NoteForm noteForm, Model model) {
		model.addAttribute("title", "新規作成");
		return "sub/create";
	}

//	@GetMapping("/{id}")
//	public String edit(NoteForm noteForm, @PathVariable int id, Model model) {
//		Optional<Note> noteOpt = noteService.getNote(id);
//
//		Optional<NoteForm> noteFormOpt = noteOpt.map(t -> makeNoteForm(t));
//
//		// NoteFormがnullでなければ中身を取り出し
//		if (noteFormOpt.isPresent()) {
//			noteForm = noteFormOpt.get();
//		}
//		model.addAttribute("noteForm", noteForm);
//		List<Note> list = noteService.getAll();
//		model.addAttribute("list", list);
//		model.addAttribute("id", id);
//		model.addAttribute("title", "更新用フォーム");
//
//		return "sub/edit";
//	}
//
//	@PostMapping("/update")
//	public String update(@Valid @ModelAttribute NoteForm noteForm, BindingResult result, @RequestParam("id") int id,
//			Model model, RedirectAttributes redirectAttributes) {
//		if (!result.hasErrors()) {
//			Note note = makeNote(noteForm, id);
//
//			noteService.update(note);
//			redirectAttributes.addFlashAttribute("complete", "変更が完了しました");
//			return "redirect:/sub/edit" + id;
//		} else {
//			model.addAttribute("noteForm", noteForm);
//			model.addAttribute("title", "タスク一覧");
//			return "sub/edit";
//		}
//	}
//
	@PostMapping("/delete") // @RequestParam hiddenのところnameで取得
	public String delete(@RequestParam("id") int id, Model model) {
		// 一件削除しリダイレクト
		noteService.deleteById(id);
		return "redirect:/layout";
	}
//
//	private Note makeNote(NoteForm noteForm, int id) {
//		Note note = new Note();
//		if (id != 0) {
//			note.setId(id);
//		}
//		note.setId(noteForm.getId());
//		note.setDateTime(noteForm.getDateTime());
//		note.setName(noteForm.getName());
//		note.setTitle(noteForm.getTitle());
//		note.setContents(noteForm.getContents());
//		return note;
//	}
//
//	// NoteのデータをNoteFormに入れて返す
//	private NoteForm makeNoteForm(Note note) {
//		NoteForm noteForm = new NoteForm();
//
//		noteForm.setId(note.getId());
//		noteForm.setDateTime(note.getDateTime());
//		noteForm.setName(note.getName());
//		noteForm.setTitle(note.getTitle());
//		noteForm.setContents(note.getContents());
//
//		return noteForm;
//	}

}
