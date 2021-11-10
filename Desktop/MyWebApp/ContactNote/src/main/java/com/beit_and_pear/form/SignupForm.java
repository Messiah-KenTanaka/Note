package com.beit_and_pear.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	@Size(min = 4, max = 30, message = "4~30桁以内で入力してください")
	private String userId;

	@NotBlank
	@Size(min = 4, max = 30, message = "4~30桁以内で入力してください")
	private String password;
}
