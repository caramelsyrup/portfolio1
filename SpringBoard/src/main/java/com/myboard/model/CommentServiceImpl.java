package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.dto.CommentDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper cmapper;
	
	@Autowired
	private BoardMapper bmapper;
	
	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Override
	@Transactional
	public void insert(CommentDTO dto) {
		// 동시 처리가 필요한 부분. 트랜젝션. 어노테이션 달아줌. 그리고 설정. root-context에서
		cmapper.doinsert(dto);
		// 댓글부분 1증가
		bmapper.updateReplyCnt(dto.getBnum(), 1);
	}

	@Transactional
	@Override
	public void delete(int cnum) {
		// 해당 게시글의 번호를 얻기 위해서 빈객체를 만듦.
		CommentDTO cdto = cmapper.read(cnum);
		// 댓글부분 1감소
		bmapper.updateReplyCnt(cdto.getBnum(), -1);
		// 댓글삭제도 동시처리가 필요함.
		cmapper.delete(cnum);
	}

}
