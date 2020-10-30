package com.myandroid.mypro;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.myandroid.VO.CategoryVO;
import com.myandroid.VO.UserVO;
import com.myandroid.model.AppUserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AppUserServiceImpl service;
	
	@GetMapping("/") public String Home() { return "home"; }
//----------------------------------------------------------------------------------------------------------------	
	
	@GetMapping(value = "login")	// 로그인판단
	@ResponseBody
	public UserVO login(String userID) {
		System.out.println(userID);
		UserVO sign = service.login(userID);
		System.out.println(sign);
		return sign;
	}
	@GetMapping(value = "signUp",produces = "application/json; charset=utf-8")	// 회원가입
	@ResponseBody
	public int signUp(String objJson) {	//
		System.out.println("====회원가입====");
		System.out.println(objJson);
		int result=0;
		Gson gson = new Gson();
		try {
			UserVO vo = gson.fromJson(objJson, UserVO.class);
			result = service.insert(vo);
			System.out.println(vo);
		}catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	// 수정하기
	@PutMapping(value = "update",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String update(String userinfo) {
		System.out.println("====수정하기====");
		System.out.println(userinfo);
		Gson gson = new Gson();
		try {
			UserVO user = gson.fromJson(userinfo, UserVO.class);
			service.update(user);
			return "1";
		}catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	// 삭제하기
	@DeleteMapping("delete")
	@ResponseBody
	public String delete(@Param("userID") String userID) {
		try {
			service.delete(userID);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
//----------------------------------------------------------------------------------------------------------------	
	// 카테고리 폼 
	@GetMapping("categoryIn")
	public String FormCategory() {
		return "categoryForm";	
	}
	// 카테고리에 추가
	@PostMapping("inputCategory")
	@ResponseBody
	public int insertCategory(CategoryVO category) {
		int result = 0;
		try {
			result = service.inputCategory(category);			
			return result;
			
		}catch (Exception e) {
			e.printStackTrace();
			return result;
		}

	}
	
}
