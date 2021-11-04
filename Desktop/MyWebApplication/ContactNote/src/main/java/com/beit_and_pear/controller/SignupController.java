package com.beit_and_pear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beit_and_pear.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	// ユーザー登録画面を表示
	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm form) {

		// ユーザー登録画面に遷移
		return "user/signup";
	}

	@PostMapping("/signup")
	public String postSignup(Model model, @ModelAttribute @Validated SignupForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		// 入力チェック
		if (result.hasErrors()) {
			return getSignup(form);
		}
		log.info(form.toString());
		redirectAttributes.addFlashAttribute("newCreate", "新規ユーザーを登録しました");
		return "redirect:/login";
	}
}
