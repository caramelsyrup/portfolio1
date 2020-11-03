package com.myspring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.dto.BoardDTO;
import com.myspring.dto.CommentDTO;
import com.myspring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper bmapper;
	
	// 전체보기
	@Override
	public List<BoardDTO> allList() {
		return bmapper.allList();
	}
	// 추가하기
	@Override
	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}
	// 상세보기
	@Override
	public BoardDTO findByNum(int num) {
		return bmapper.findByNum(num);
	}
	// 조회 수 올리기
	@Override
	public void updateCount(int num) {
		bmapper.updateCount(num);
	}
	// 댓글 추가하기
	@Override
	public void Cominsert(CommentDTO dto) {
		bmapper.Cominsert(dto);
	}
	@Override
	public List<CommentDTO> listComment(int bnum) {
		// TODO Auto-generated method stub
		return bmapper.listComment(bnum);
	}
	
	
	
}
