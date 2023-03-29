package com.example.demo.application.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.constant.Constant;
import com.example.demo.domain.form.user.SearchForm;
import com.example.demo.domain.model.UserData;
import com.example.demo.domain.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = Constant.LOCALHOST_3000)
@RequestMapping(Constant.MAP_API)
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(Constant.MAP_SEARCH_USER_LIST)
	public List<UserData> searchUserList(SearchForm searchForm) {
		log.info("[開始]ユーザーリスト取得");
		// [検索]ユーザー
		List<UserData> userList = userService.selectUserList(searchForm);
		log.info("[終了]ユーザーリスト取得");
		return userList;
	}

	@GetMapping(Constant.MAP_DOWNLOAD_CSV)
	public void downloadCsv(HttpServletResponse response, SearchForm searchForm)
			throws IOException {
		log.info("[開始]CSVユーザーリスト取得");

		// [検索]ユーザー
		List<UserData> userList = userService.selectUserList(searchForm);

		// レスポンスヘッダー設定
		response.setContentType(Constant.TEXT_CSV);
		response.setCharacterEncoding(Constant.SHIFT_JIS);
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"userList.csv\"");

		// CSVファイル書込
		try (var writer = response.getWriter()) {
			// ヘッダー
			writer.write(String.join(Constant.COMMA, Constant.USER_ID, Constant.USER_NM));
			// 明細
			writer.write(Constant.NEW_LINE);
			for (UserData userData : userList) {
				writer.write(
						String.join(Constant.COMMA,
								userData.getUserId() != null ? userData.getUserId() : Constant.EMPTY,
								userData.getUserNm() != null ? userData.getUserNm() : Constant.EMPTY));
				writer.write(Constant.NEW_LINE);
			}
		}
		log.info("[終了]CSVユーザーリスト取得");
	}
}
