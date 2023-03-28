package com.example.demo.domain.form.login;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginForm {
	private String email;
	private String password;
}
