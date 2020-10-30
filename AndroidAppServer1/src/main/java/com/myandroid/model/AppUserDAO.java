package com.myandroid.model;

import java.util.List;

import com.myandroid.VO.UserVO;

public interface AppUserDAO {
	// 회원 정보 조회
	public List<UserVO> dao_list();
	// 회원 로그인
	public UserVO dao_login(String userID);
	// 회원 정보 상세 조회
	public UserVO dao_findById(String userID);
	// 회원 추가
	public int dao_insert(UserVO user);
	// 회원 정보 수정
	public void dao_update(UserVO user);
	// 회원 정보 삭제
	public void dao_delete(String userID);
}
