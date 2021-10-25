package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	// ログイン画面を表示
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("title", "ログイン");
		return "login/login";
	}

	// ユーザー一覧画面へリダイレクト
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/layout";
	}
}
