package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOImpl dao;
	
	@Override
	public int insert(BoardDTO board) {
		
		return dao.dao_insert(board);
	}

	@Override
	public List<BoardDTO> findAll(HashMap<String, Object> hm) {
		
		return dao.dao_findAll(hm);
	}

	@Override
	public BoardDTO findByNum(int num) {
		
		return dao.dao_findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		dao.dao_update(board);
		
	}

	@Override
	public int delete(int num) {
		
		return dao.dao_delete(num);
		
	}

	@Override
	public List<BoardDTO> listAll(SearchDTO dto) {
		
		return dao.dao_listAll(dto);
	}

	@Override
	public int getCount(SearchDTO dto) {
		// TODO Auto-generated method stub
		return dao.dao_getCount(dto);
	}
	
}
