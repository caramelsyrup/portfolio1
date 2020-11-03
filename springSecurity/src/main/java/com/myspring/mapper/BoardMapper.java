package com.myspring.mapper;

import java.util.List;

import com.myspring.dto.BoardDTO;
import com.myspring.dto.CommentDTO;

public interface BoardMapper {
	
	// 글 전체보기
	public List<BoardDTO> allList();
	
	// 글 추가하기
	public void insert(BoardDTO board);
	
	// 글 상세보기
	public BoardDTO findByNum(int num);
	
	// 글 조회수 올리기
	public void updateCount(int num);
	// 댓글 보기
	public List<CommentDTO>listComment(int bnum);
	// 댓글 쓰기
	public void Cominsert(CommentDTO dto);
	
}
