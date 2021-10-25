package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MUser;
import com.example.demo.model.SignupForm;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignupController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// ユーザー登録画面を表示
	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm form, Model model) {

		model.addAttribute("signup", "ユーザー登録画面");

		return "login/signup";
	}

	// ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute @Validated SignupForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "login/signup";
		}
		log.info(form.toString());

		// formをMUserクラスに変換
		MUser mUser = modelMapper.map(form, MUser.class);
		// ユーザー登録
		userService.signup(mUser);

		// ログイン画面へリダイレクト
		return "redirect:/login";
	}

}
