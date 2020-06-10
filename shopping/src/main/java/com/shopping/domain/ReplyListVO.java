package com.shopping.domain;

import java.util.Date;

public class ReplyListVO {
	
	private String GP_id;
	private String userId;
	private int reqNum;
	private String repCon;
	private Date repDate;
	
	private String userName;

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

	public int getReqNum() {
		return reqNum;
	}

	public void setReqNum(int reqNum) {
		this.reqNum = reqNum;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
