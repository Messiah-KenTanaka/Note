package com.beit_and_pear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	// ログイン画面を表示
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}

	// ログインしてNote画面へ遷移
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/list";
	}
}
