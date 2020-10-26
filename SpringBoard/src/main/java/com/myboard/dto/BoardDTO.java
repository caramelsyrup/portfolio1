package com.myboard.dto;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int num;
	private String title;
	private String content;
	private String writter;
	private String regdate;
	private int hitcount;
	private String password;
	
}
