package com.myboard.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String ID;
	private String PASS;
	private String NAME;
	private String ADDR;
	private String MEMO;
	private Date REG_DATE;
}
