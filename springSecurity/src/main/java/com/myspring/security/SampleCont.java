package com.myspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// views 폴더안에 sample 폴더를 만든뒤 jsp 파일
@Controller
@RequestMapping("/sample/*")
public class SampleCont {
	
	@GetMapping("admin")
	public void admin() {
	}
	@GetMapping("all")
	public void all() {
	}
	@GetMapping("member")
	public void member() {
	}

}
