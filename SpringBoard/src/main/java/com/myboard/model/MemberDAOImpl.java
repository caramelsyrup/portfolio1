package com.myboard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.dto.MemberDTO;
import com.myboard.mapper.MemberMapper;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private MemberMapper memapper;
	
	// 회원가입
	@Override
	public int dao_insertMember(MemberDTO dto) {
		return memapper.insertMember(dto);
	}

}
