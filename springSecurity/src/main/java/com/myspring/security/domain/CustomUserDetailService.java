package com.myspring.security.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myspring.dto.MemberDTO;
import com.myspring.mapper.MemberMapper;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberDTO member = memberMapper.read(username);
		
		// member가 널이 아니라면 내가 만든 멤버를 반환.
		return member==null?null:new CustomUser(member);
	}

}
