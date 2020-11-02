package com.myspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SampleController {
	
	@GetMapping("/customLogin")
	public void doMember() {
		log.info("logined member");
	}
	
}
