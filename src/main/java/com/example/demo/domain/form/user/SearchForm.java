package com.example.demo.domain.form.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SearchForm {
	private String userId;
	private String userNm;
}
