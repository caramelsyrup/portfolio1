package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardDAO {
	// 카운트
	public int dao_getCount(SearchDTO dto);
	// 추가
	public int dao_insert(BoardDTO board);
	// 리스트
	public List<BoardDTO> dao_findAll(HashMap<String, Object>hm);
	// 뉴 리스트
	public List<BoardDTO> dao_listAll(SearchDTO dto);
	// 상세보기
	public BoardDTO dao_findByNum(int num);
	// 수정
	public void dao_update(BoardDTO board);
	// 삭제
	public int dao_delete(int num);
}
