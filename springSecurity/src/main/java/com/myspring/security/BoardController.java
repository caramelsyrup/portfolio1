package com.myspring.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.dto.BoardDTO;
import com.myspring.dto.CommentDTO;
import com.myspring.model.BoardServiceImpl;

import lombok.extern.log4j.Log4j;


// @RequestMapping으로 views에 board폴더를 만들어서 해당 화면 파일을 관리 할 수 있다.
@Log4j
@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl bservice;
	
	@GetMapping("/boardInsert")
	@PreAuthorize("isAuthenticated()")	// 권한 검사를 하라. 권한 없으면 회원가입창으로
	public void register() {
		
	}
	// 글 추가하기
	@PostMapping("insert")
	public String doinsert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:/board/list";
	}
	// 글 전체 보기
	@GetMapping("/list")
	public void doList(Model mv) {
		List<BoardDTO>list = bservice.allList();
		mv.addAttribute("list", list);
	}
	// 글 상세 보기
	@GetMapping("view")
	public void findByNum(Model m,int num) {
		bservice.updateCount(num);
		BoardDTO board = bservice.findByNum(num);
		m.addAttribute("user", board);
	}
	// 댓글 보기
	@GetMapping("reply/commentList")
	@ResponseBody
	public List<CommentDTO> listComment(int bnum){
		List<CommentDTO> list =bservice.listComment(bnum); 
		return list;
		
	}
	// 댓글쓰기
	@PostMapping("reply/commentInsert")
	@ResponseBody
	public void insertComment(@RequestBody CommentDTO dto) {
		bservice.Cominsert(dto);
	}
	
}
