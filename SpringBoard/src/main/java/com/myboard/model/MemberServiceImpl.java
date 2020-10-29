package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.AddressDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.mapper.MemberMapper;

// 유효성 체크
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mmapper;
	
	@Autowired
	private MemberDAOImpl dao; 
	
	// 아이디체크
	@Override
	public MemberDTO IDCheck(String ID) {
		MemberDTO dto =  mmapper.idcheck(ID);
		return dto;
	}
	
	// 회원가입
	@Override
	public int insertMember(MemberDTO dto) {
		return dao.dao_insertMember(dto);
	}
	
	// 주소검색
	@Override
	public List<AddressDTO> address(String dong) {
		return mmapper.address(dong);
	}

	@Override
	public MemberDTO login(String LID) {
		return mmapper.login(LID);
	}

}
