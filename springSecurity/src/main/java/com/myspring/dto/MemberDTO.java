package com.myspring.dto;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String USERID;
	private String USERPW;
	private String USERNAME;
	private boolean ENABLED;
	
	private String REGDATE;
	private String UPDATEDATE;
	
	// 1대 다 관계를 나타내기 위해서, 리스트형으로 정함.
	private List<AuthDTO> authList;
	
	
}
