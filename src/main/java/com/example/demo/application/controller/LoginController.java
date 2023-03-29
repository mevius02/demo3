package com.example.demo.application.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.domain.constant.Constant;
import com.example.demo.domain.form.login.LoginForm;
import com.example.demo.domain.model.UserData;
import com.example.demo.domain.service.UserService;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = Constant.LOCALHOST_3000)
@RequestMapping(Constant.MAP_API)
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(Constant.MAP_LOGIN)
	public ResponseEntity<UserData> login(LoginForm loginForm) {
		UserData user = new UserData();
		if (!StringUtils.isEmpty(loginForm.getEmail()) && !StringUtils.isEmpty(loginForm.getPassword())) {
			user = userService.selectLoginUser(loginForm);
		}
		return new ResponseEntity<UserData>(user, HttpStatus.OK);
	}
}
