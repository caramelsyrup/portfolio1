package com.myboard.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.omg.CORBA.BAD_INV_ORDER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.myboard.dto.BoardDTO;
import com.myboard.model.BoardServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 추가폼 불러오기
	@GetMapping(value = "boardInsert")
	public String insert() {
		return "boardInsert";
	}
	
	// 추가 기능 실행 후 홈화면
	@PostMapping("boardInsert")
	@ResponseBody
	public int insert(BoardDTO board) {
		int result = 0;
		result = service.insert(board);
		if(result!=0) {
			System.out.println("글 작성 성공!");
			return result;
		}else {
			System.out.println("문제발생");
			return result;
		}
		
	}
	
	// 전체보기
	@GetMapping("boardList")
	@ResponseBody
	public List<BoardDTO> list(String field, String word) {
		// 여러 데이터를 다 담기 위해서 해쉬맵 사용.
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// 검색을 위한 키워드와 카테고리 저장.
		hm.put("field", field);
		hm.put("word", word);
		List<BoardDTO> list = service.findAll(hm);
		
		return list;
	}
	
	// 상세보기
	@GetMapping("view")
	@ResponseBody
	public BoardDTO findByNum(int num) {
		BoardDTO dto = service.findByNum(num);
		int hitcount = dto.getHitcount()+1;
		dto.setHitcount(hitcount);
		service.update(dto);
		return dto;
	}
	// 수정하기 폼으로
	@GetMapping("boardUpdate")
	public String update(int num,Model mv) {
		BoardDTO dto = service.findByNum(num);
		mv.addAttribute("user", dto);
		return "update";
	}
	// 수정하기 기능
	@PostMapping("boardUpdate")
	public String update(BoardDTO board) {
		service.update(board);
		return "home";
	}
	// 삭제하기
	@GetMapping("boardDelete")
	@ResponseBody
	public int delete(int num) {
		int result = service.delete(num);
		return result;
	}
	
}
