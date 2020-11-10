package com.mysql.pro.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Users")
public class Userinfo implements UserDetails{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	
	@Column(unique = true)
	private String account;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "auth")
	private String auth;
	
	@Column(name = "reg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	@Builder
	public Userinfo(String account, String pwd, String auth) {
		this.account = account;
		this.pwd = pwd;
		this.auth = auth;
	}
	
	// 사용자 권한을 콜렉션 형태로 반환. 클래스 자료형은 GrantedAuthority를 구현해야함.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet<>();
		for(String role : auth.split(",")) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return roles;
	}
	
	// 사용자 패스워드 반환
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pwd;
	}
	
	// 사용자 아이디(계정) 반환
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return account;
	}
	
	// 계정 만료 여부 반환
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;	// 만료되지 않았음.
	}
	
	// 계정 잠금 여부 반환
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;	// 잠금되지 않음.
	}

	// 패스워드 만료 여부 반환
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;	// 만료되지 않음.
	}
	
	// 계정 사용 가능 여부 반환
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;	// 사용 가능
	}
	
	
	
	
	
	
	
}
