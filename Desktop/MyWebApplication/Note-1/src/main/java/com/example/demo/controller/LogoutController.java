package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class LogoutController {

	// ログイン画面へリダイレクト
	@GetMapping("/logout")
	public String getLogout() {
		log.info("ログアウト");
		return "redirect:/login";
	}

	@PostMapping("/logout")
	public String postLogout() {
		log.info("ログアウト");
		return "redirect:/login";
	}
}
