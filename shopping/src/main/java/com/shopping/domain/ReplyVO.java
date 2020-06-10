package com.shopping.domain;

import java.util.Date;

public class ReplyVO {
	
	private String GP_id;
	private String userId;
	private int repNum;
	private String repCon;
	private Date repDate;
	public String getGP_id() {
		return GP_id;
	}
	public void setGP_id(String gP_id) {
		GP_id = gP_id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	
	

}
