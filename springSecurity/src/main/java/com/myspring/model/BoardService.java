package com.myspring.model;

import java.util.List;

import com.myspring.dto.BoardDTO;
import com.myspring.dto.CommentDTO;

public interface BoardService {
	
	// 글 전체 보기
	public List<BoardDTO> allList();
	// 글 추가 하기
	public void insert(BoardDTO board);
	// 글 상세 보기
	public BoardDTO findByNum(int num);
	// 글 조회수 올리기
	public void updateCount(int num);
	// 댓글보기
	public List<CommentDTO> listComment(int bnum);
	// 댓글 추가
	public void Cominsert(CommentDTO dto);
}
