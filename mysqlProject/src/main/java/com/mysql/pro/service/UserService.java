package com.mysql.pro.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysql.pro.domain.Userinfo;
import com.mysql.pro.domain.UserinfoDTO;
import com.mysql.pro.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	// 유저 회원가입. 회원 정보 저장.
	public Long save(UserinfoDTO userDTO) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userDTO.setPwd(encoder.encode(userDTO.getPwd()));
		return userRepository.save(Userinfo.builder()
				.account(userDTO.getAccount())
				.auth(userDTO.getAuth())
				.pwd(userDTO.getPwd()).build()).getCode();
	}
	
	// 로그인을 위해서
	// 기본 반환 타입은 UserDetails형이나 UserDetails을 상속받는 Userinfo로 반환타입 지정됨.(다운캐스팅)
	@Override
	public Userinfo loadUserByUsername(String account) throws UsernameNotFoundException {
		// spring security에서 지정한 서비스 필수로 메서드 구현.
		
		return userRepository.findByAccount(account)	// null이 아니면 Userinfo반환.
				.orElseThrow(()->new UsernameNotFoundException(account));	// null이면 예외 발생.
	}
}
