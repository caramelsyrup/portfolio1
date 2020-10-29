package com.myboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.model.CommentService;

// REST API 사용시에 reply를 타고 넘어 오도록 유도 된 것들은 매번 적어줘야하는데, 이를 생략하게 함.
@RequestMapping("/reply")
@Controller
// @RestController 를 사용하면, 개별 경로에 @ResponseBody 가능.
public class CommentController {
	@Autowired
	private CommentService cservice;

	@GetMapping("commentList")	/* /reply/commentList 인데, 위에 설정으로 가능. */
	@ResponseBody
	public List<CommentDTO> list(int bnum) {
		System.out.println(bnum);
		List<CommentDTO> clist = cservice.getList(bnum);
		return clist;
	}
	
	@PostMapping("commentInsert")
	@ResponseBody
	public int insert(@RequestBody CommentDTO dto) {
		System.out.println(dto.getUserid());
		try {
			cservice.insert(dto);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}
	
	@DeleteMapping(value = "cdelete/{cnum}",produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String cdelete(@PathVariable int cnum) {
		System.out.println(cnum);
		cservice.delete(cnum);
		
		return "1";
	}
	
	
	/*
	 * @GetMapping("cdelete")
	 * @ResponseBody public int delete(int cnum) {
	 * int result = cservice.delete(cnum);
	 *  return result; }
	 */
}
