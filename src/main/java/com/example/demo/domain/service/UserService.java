package com.example.demo.domain.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	public Boolean insertUsers(List<String[]> insertList) {
		for (String[] insertArr : insertList) {
			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
			String limit = LocalDateTime.now().plusYears(10).format(DateTimeFormatter.BASIC_ISO_DATE);
			UserData userData = new UserData();
			userData.setUpdateCnt(0);
			userData.setUserId(insertArr[0]);
			userData.setPassword(insertArr[1]);
			userData.setUserNm(insertArr[2]);
			userData.setAccountExpiration(limit);
			userData.setPasswordExpiration(limit);
			userData.setEnabled(true);
			userData.setInsertUserId("init");
			userData.setInsertTimestamp(now);
			userData.setUpdateUserId(null);
			userData.setUpdateTimestamp(null);
			if (1 != userMapper.insertUser(userData)) {
				return false;
			}
		}
		return true;
	}
}
