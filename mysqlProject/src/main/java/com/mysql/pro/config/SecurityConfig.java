package com.mysql.pro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mysql.pro.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity		// spring security를 활성화
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {	// spring security 설정파일이 되려면 반드시 상속
	
	@Autowired
	private final UserService  userservice;		// 사용할 유저 정보를 가져올 클래스
	
	@Bean
	public PasswordEncoder passwordEncoder() {	// 비밀번호 암호화할때 사용할 인코더를 미리 빈으로 등록
		return new BCryptPasswordEncoder();
		
	}

	@Override	// WebSecurityConfigurerAdapter상속으로 가능한 메서드, 인증 무시하고 가능한 경로들
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/img/**");
	}
	
	
	
	@Override	// WebSecurityConfigurerAdapter상속으로 가능한 메서드
	protected void configure(HttpSecurity http) throws Exception {	
		http
			.authorizeRequests()		// 접근에 대한 인증 설정.
				.antMatchers("/home","/signup").permitAll()	// 경로설정과 권한설정. 누구나 접근
				.antMatchers("/user/**").hasRole("USER")	// USER,ADMIN만 접근 가능
				.antMatchers("/admin").hasRole("ADMIN")		// ADMIN만 접근 가능.
				.anyRequest().authenticated()			// 나머지 요청들은 권한 종류 상관 없이, 권한 있어야 접근 가능.
			.and()
				.formLogin()				// 로그인 관련 설정
					.loginPage("/home")		// 로그인 페이지 링크
					.defaultSuccessUrl("/board/list")	// 로그인 성공후 리다이렉트 주소
					.failureUrl("/login-error")
			.and()
				.logout()					// 로그아웃 설정
					.invalidateHttpSession(true)	// 세션 날리기
					.logoutSuccessUrl("/home");		// 로그아웃 성공시 리다이렉트 주소
	}

	@Override	// 로그인시 필요한 정보를 가져옴
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 유저 정보를 가져오는 서비스를 지정.
		// 패스워드 인코더는 위의 작성한 메소드 사용.
		auth.userDetailsService(userservice).passwordEncoder(passwordEncoder());
	}
	
	



	
	
}
