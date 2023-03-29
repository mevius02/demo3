package com.example.demo.infrastructure.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.form.login.LoginForm;
import com.example.demo.domain.form.user.SearchForm;
import com.example.demo.domain.model.UserData;

@Mapper
public interface UserMapper {
	UserData selectLoginUser(LoginForm loginForm);

	List<UserData> selectUserList(SearchForm searchForm);

	int insertUser(UserData userData);
}
