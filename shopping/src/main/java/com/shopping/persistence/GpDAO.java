package com.shopping.persistence;

import java.util.List;

import com.shopping.domain.GoodPVO;
import com.shopping.domain.GpCategoryVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;

public interface GpDAO {

	// 댓글 작성
	public void registReply(ReplyVO reply) throws Exception;

	// 댓글 리스트
	public List<ReplyListVO> replyList(int GP_id) throws Exception;

	// 카테고리 리스트
	public List<GpCategoryVO> cateList() throws Exception;

	// 주차장 등록
	public void GP_reg(GoodPVO vo) throws Exception;
}
