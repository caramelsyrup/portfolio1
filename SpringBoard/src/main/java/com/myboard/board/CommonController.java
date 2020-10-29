package com.myboard.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model mv) {
		System.out.println("customLogin");
		
		if(error!=null) {
			mv.addAttribute("error", "Login error");
		}
		if(logout!=null) {
			mv.addAttribute("logout", "ByeBye");
		}
		
	}
	
}
