package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.form.login.LoginForm;
import com.example.demo.domain.form.user.SearchForm;
import com.example.demo.domain.model.UserData;
import com.example.demo.infrastructure.persistence.mapper.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired
	UserMapper userMapper;

	public UserData selectLoginUser(LoginForm loginForm) {
		return userMapper.selectLoginUser(loginForm);
	}

	public List<UserData> selectUserList(SearchForm searchForm) {
		return userMapper.selectUserList(searchForm);
	}
}
