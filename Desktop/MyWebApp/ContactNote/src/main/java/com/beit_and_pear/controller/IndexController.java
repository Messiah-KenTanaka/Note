package com.beit_and_pear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@PostMapping("/")
	public String postIndex() {
		return "index";
	}

	@GetMapping("/getlogin")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/getlogin")
	public String postLogin() {
		return "login";
	}
}
