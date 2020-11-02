package com.myboard.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.AddressDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.model.MemberServiceImpl;

// 회원 관련 컨트롤러
@RequestMapping("/member")
@Controller
public class MemberController {
	
	// 서비스에 접근하여 autowired
	@Autowired
	private MemberServiceImpl memservice;
	
	// 회원 가입 폼 화면
	@GetMapping("insertUser")
	public String insertForm() {
		return "join";
	}
	
	// 회원가입기능, 이후 로그인 화면
	@PostMapping("insertUser")
	public String insert(MemberDTO dto) {
		memservice.insertMember(dto);
		return "login";
	}
	
	// 회원 로그인
	@PostMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request,@Param("LID") String LID, @Param("LPASS") String LPASS) {
		System.out.println(LID);
		try {
			MemberDTO dto = memservice.IDCheck(LID);
			if(dto.getPASS().equals(LPASS)) {
				System.out.println("로그인성공");
				HttpSession session = request.getSession();
				session.setAttribute("Member", dto);
				return "0";
			}else {
				System.out.println("비밀번호 오류");
				return "1";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "-2";
		}
			
	}
//=====================================================================================================	
	// 아이디 중복체크
	@GetMapping(value = "checkID/{ID}")
	@ResponseBody
	public int IDCheck(@PathVariable String ID) {
		MemberDTO dto =  memservice.IDCheck(ID);
		if(dto != null) {	// 결과값이 있으면 아이디가 존재
			return 0;		// 아이디 사용 불가
		}else {				// 결과 값이 없으면 아이디 없음
			return 1;		// 아이디 사용 가능
		}
	}
	// 우편번호 체크
	// 창띄우기
	@GetMapping("addrCheck")
	public String addrCheck() {
		return "addrCheck";
	}
	// 주소검색
	@PostMapping(value = "address")
	@ResponseBody
	public List<AddressDTO>address(String dong){
		List<AddressDTO> list = memservice.address(dong);
		return list;
	}
}
