package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardMapper {
	// 카운트
	public int getCount(SearchDTO dto);
	// 추가
	public int insert(BoardDTO board);
	// 리스트
	public List<BoardDTO> findAll(HashMap<String, Object>hm);
	// 뉴 리스트
	public List<BoardDTO> listAll(SearchDTO dto);
	// 상세보기
	public BoardDTO findByNum(int num);
	// 수정
	public void update(BoardDTO board);
	// 삭제
	public int delete(int num);
	
	// reply 개수 증가
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);	// 매개변수를 "이름"으로 전달
}
