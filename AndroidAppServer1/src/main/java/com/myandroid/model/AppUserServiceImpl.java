package com.myandroid.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myandroid.VO.CategoryVO;
import com.myandroid.VO.UserVO;
import com.myandroid.mapper.CategoryMapper;

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserDAOImpl dao;
	
	@Autowired
	private CategoryMapper cmapper;
	
	@Override
	public List<UserVO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	// 회원가입
	@Override
	public int insert(UserVO user) {
		int result = dao.dao_insert(user);
		return result;
		
	}
	
	// 수정하기
	@Override
	public void update(UserVO user) {
		dao.dao_update(user);
		
	}
	
	// 삭제
	@Override
	public void delete(String userID) {
		dao.dao_delete(userID);
		
	}
	
	// 로그인
	@Override
	public UserVO login(String userID) {
		UserVO sign = dao.dao_login(userID);
		return sign;
	}

	// 카테고리 추가
	@Override
	public int inputCategory(CategoryVO category) {
		return cmapper.inputCategory(category);
	}

}
