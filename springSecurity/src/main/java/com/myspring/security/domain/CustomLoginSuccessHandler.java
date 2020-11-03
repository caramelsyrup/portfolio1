package com.myspring.security.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	// 객체를 자동 주입.
	@Autowired
	private PasswordEncoder passowrdencoder;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
			String endPwd = passowrdencoder.encode(request.getParameter("password"));
			
			System.out.println("password : "+endPwd);
			
			List<String> roleNames = new ArrayList<String>();
			
			authentication.getAuthorities().forEach(auth -> {roleNames.add(auth.getAuthority());});
			
			System.out.println("roleName : "+roleNames);
			
			if(roleNames.contains("ROLE_ADMIN")) {
				response.sendRedirect("/security/sample/admin");
				return;
			}
			if(roleNames.contains("ROLE_MEMBER")) {
				response.sendRedirect("/security/sample/member");
				return;
			}
			response.sendRedirect("/security");
		
	}

	
	
}
