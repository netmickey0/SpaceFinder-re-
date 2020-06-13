package com.shopping.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shopping.domain.GpCategoryVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;

@Repository
public class GpDAOImpl implements GpDAO {
	
	@Inject
	private SqlSession sql;
	
	// 매퍼 
	private static String namespace = "com.shopping.mappers.adminMapper";

	
	//댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		 sql.insert(namespace + ".registReply", reply);
	}

	// 댓글 리스트
	@Override
	public List<ReplyListVO> replyList(int GP_id) throws Exception {
		return sql.selectList(namespace + ".replyList", GP_id);
	}

	@Override
	public List<GpCategoryVO> cateList() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".cateList");
	}
}
