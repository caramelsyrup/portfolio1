package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.AddressDTO;
import com.myboard.dto.MemberDTO;

public interface MemberMapper {
	
	// 아이디 검사
	public MemberDTO idcheck(String ID);
	
	// 회원가입
	public int insertMember(MemberDTO dto);
	
	// 주소 검색
	public List<AddressDTO> address(String addrText);
	
	// 로그인
	
	public MemberDTO login(String LID);
	
}
