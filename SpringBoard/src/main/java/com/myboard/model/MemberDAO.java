package com.myboard.model;

import com.myboard.dto.MemberDTO;

public interface MemberDAO {
	// 회원가입
	public int dao_insertMember(MemberDTO dto);
	
}
