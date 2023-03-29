package com.example.demo.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserData {
	private Integer updateCnt;
	private String userId;
	private String password;
	private String userNm;
	private String accountExpiration;
	private String passwordExpiration;
	private Boolean enabled;
	private String insertUserId;
	private String insertTimestamp;
	private String updateUserId;
	private String updateTimestamp;
}
