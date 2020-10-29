package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
	// 추가
	public int doinsert(CommentDTO dto);
	// 보기
	public List<CommentDTO> getList(int bnum);
	// 댓글삭제
	public void delete(int cnum);
	// 상세보기
	public CommentDTO read (int cnum);
	
	
}
