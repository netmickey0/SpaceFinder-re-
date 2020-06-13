package com.shopping.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;

import com.shopping.domain.GpCategoryVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;
import com.shopping.persistence.GpDAO;

@Service
public class GpServiceImpl implements GpService {
	
	@Inject
	private GpDAO dao;


	
	//댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
	}


	//댓글 리스트
	@Override
	public List<ReplyListVO> replyList(int GP_id) throws Exception {
		return dao.replyList(GP_id);
	}


	@Override
	public List<GpCategoryVO> cateList() throws Exception {
		// TODO Auto-generated method stub
		return dao.cateList();
	}

}
