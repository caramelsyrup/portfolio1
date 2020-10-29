package com.myboard.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.BAD_INV_ORDER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.myboard.dto.BoardDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.model.BoardServiceImpl;
import com.myboard.model.MemberServiceImpl;
import com.myboard.util.SearchDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardServiceImpl service;
	@Autowired
	private MemberServiceImpl mservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "login";
	}
	
	// 게시글 추가폼 불러오기
	@GetMapping(value = "boardInsert")
	public String insert() {
		return "boardInsert";
	}
	// 게시글 추가 기능 실행 후 홈화면
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
	
	// 게시글 전체보기
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
	
	// 전체보기 페이지, 검색기능 넣기
	@GetMapping("sboardList")
	public String list(Model mv ,SearchDTO dto){
		int count = service.getCount(dto);
		List<BoardDTO> list = service.listAll(dto);
		int rowNo = count - ((dto.getPageNum()-1)*10);
		mv.addAttribute("list", list);
		mv.addAttribute("count", count);
		mv.addAttribute("rowNo", rowNo);
		return "list";
	}
//==========================================================================================================================		
	// REST
	// 상세보기 페이지로 이동/REST 를 이용하는 매개변수 가지고 페이지 이동.
	@GetMapping("reply/{num}")
	public String get(Model mv, @PathVariable("num") int num) {
		// 조회수 늘리기
		BoardDTO dto = service.findByNum(num);
		int add = dto.getHitcount();
		add +=1;
		dto.setHitcount(add);
		service.update(dto);
		mv.addAttribute("user", dto);
		return "update";	
	}
	// 전체보기 페이지, 검색기능 넣기
	@GetMapping("reply/sboardList")
	public String lists(Model mv ,SearchDTO dto){
		int count = service.getCount(dto);
		List<BoardDTO> list = service.listAll(dto);
		int rowNo = count - ((dto.getPageNum()-1)*10);
		mv.addAttribute("list", list);
		mv.addAttribute("count", count);
		mv.addAttribute("rowNo", rowNo);
		return "list";
	}
	// 수정하기 기능
	@PostMapping("reply/boardUpdate")
	public String updates(BoardDTO board) {
		service.update(board);
		return "redirect:sboardList";
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
//==========================================================================================================================	

	
}
