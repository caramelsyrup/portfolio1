package com.mysql.pro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.pro.domain.UserinfoDTO;
import com.mysql.pro.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	//회원가입화면 가기
	@GetMapping("/signForm")
	public String signForm() {
		return "signForm";
	}
	
	// 회원가입 기능 후, 첫화면
	@PostMapping(path = "/signup")
	public String signUp (UserinfoDTO user) {
		uservice.save(user);
		return "redirect:/home";
	}
	
	
	// 로그인 구현
	@PostMapping(path = "/login")
	public String login() {
		return null;
	}
	
	
	// 로그아웃 구현. get요청으로도 로그아웃이 됨.
	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/home";
		
	}
}
