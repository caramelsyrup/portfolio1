package com.myandroid.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myandroid.VO.UserVO;
import com.myandroid.mapper.AppUserMapper;

@Repository
public class AppUserDAOImpl implements AppUserDAO {
	
	@Autowired
	private AppUserMapper mapper;
	
	@Override
	public List<UserVO> dao_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO dao_findById(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dao_insert(UserVO user) {
		return mapper.insert(user);
	}

	@Override
	public void dao_update(UserVO user) {
		mapper.update(user);
		
	}

	@Override
	public void dao_delete(String userID) {
		mapper.delete(userID);
		
	}

	@Override
	public UserVO dao_login(String userID) {
		return mapper.login(userID);	
	}

}
