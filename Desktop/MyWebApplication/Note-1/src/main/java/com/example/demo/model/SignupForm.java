package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	@Size(min = 4, max = 30, message = "4~30文字以内,半角英数字で入力してください")
	private String userId;

	@NotBlank
	@Length(min = 4, max = 30, message = "4~30文字以内,半角英数字で入力してください")
	private String password;
}
