package com.myspring.dto;

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
	
	// 빈번히 테이블이 조인될것 같은 상항에는 빈에 추가하는 것이 효율적.
	private int replyCnt;
	
}
