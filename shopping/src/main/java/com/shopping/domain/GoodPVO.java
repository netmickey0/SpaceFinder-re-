package com.shopping.domain;

import java.util.Date;

public class GoodPVO {
	/*
	 * create table GoodPlace (
    GP_id       varchar2(20)          not null,
    userId VARCHAR(50) not null,
    GP_name      varchar2(20)    not null,
    GP_category     varchar2(20)    not null,
    GP_lat    VARCHAR2(50)          not null,
    GP_long     VARCHAR2(50)        null,
    GP_Runtime       varchar(20)    null,
    GP_content       varchar(1000)    null,
    GP_image      varchar(50)           null,
    GP_click number(6) DEFAULT 0,
    GP_restday varchar(20) null,
    GP_parking varchar(100) null,
    primary key(GP_id),
    foreign key(userId) references tbl_member(userId)
);
	 */
	
	private String GP_id;
	private String userId;
	private String GP_name;
	private String GP_category;
	private String GP_lat;
	private String GP_long;
	private String GP_Runtime;
	private String GP_content;
	private String GP_image;
	private String GP_click;
	private String GP_restday;
	private String GP_parking;
	private Date GP_date;
	
	private String GP_ThumbImg;

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

	public String getGP_name() {
		return GP_name;
	}

	public void setGP_name(String gP_name) {
		GP_name = gP_name;
	}

	public String getGP_category() {
		return GP_category;
	}

	public void setGP_category(String gP_category) {
		GP_category = gP_category;
	}

	public String getGP_lat() {
		return GP_lat;
	}

	public void setGP_lat(String gP_lat) {
		GP_lat = gP_lat;
	}

	public String getGP_long() {
		return GP_long;
	}

	public void setGP_long(String gP_long) {
		GP_long = gP_long;
	}

	public String getGP_Runtime() {
		return GP_Runtime;
	}

	public void setGP_Runtime(String gP_Runtime) {
		GP_Runtime = gP_Runtime;
	}

	public String getGP_content() {
		return GP_content;
	}

	public void setGP_content(String gP_content) {
		GP_content = gP_content;
	}

	public String getGP_image() {
		return GP_image;
	}

	public void setGP_image(String gP_image) {
		GP_image = gP_image;
	}

	public String getGP_click() {
		return GP_click;
	}

	public void setGP_click(String gP_click) {
		GP_click = gP_click;
	}

	public String getGP_restday() {
		return GP_restday;
	}

	public void setGP_restday(String gP_restday) {
		GP_restday = gP_restday;
	}

	public String getGP_parking() {
		return GP_parking;
	}

	public void setGP_parking(String gP_parking) {
		GP_parking = gP_parking;
	}

	public Date getGP_date() {
		return GP_date;
	}

	public void setGP_date(Date gP_date) {
		GP_date = gP_date;
	}

	public String getGP_ThumbImg() {
		return GP_ThumbImg;
	}

	public void setGP_ThumbImg(String gP_ThumbImg) {
		GP_ThumbImg = gP_ThumbImg;
	}

	
	
	
	
}
