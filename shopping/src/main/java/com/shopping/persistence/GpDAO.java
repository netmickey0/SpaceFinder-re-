package com.shopping.persistence;

import java.util.List;

import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;

public interface GpDAO {
	
	//댓글 작성
	public void registReply(ReplyVO reply) throws Exception;

	//댓글 리스트
	public List<ReplyListVO> replyList(int GP_id) throws Exception;
}
