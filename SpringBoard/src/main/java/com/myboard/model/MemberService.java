package com.myboard.model;

import java.util.List;

import com.myboard.dto.AddressDTO;
import com.myboard.dto.MemberDTO;

public interface MemberService {
	// 아이디 중복 검사
	public MemberDTO IDCheck(String ID);
	// 회원가입
	public int insertMember(MemberDTO dto);
	// 주소록 검사
	public List<AddressDTO>address(String dong);
	// 로그인판단
	public MemberDTO login(String LID);
	
}
