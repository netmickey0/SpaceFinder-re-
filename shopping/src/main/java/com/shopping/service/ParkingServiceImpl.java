package com.shopping.service;

import com.shopping.domain.ParkingVO;
import com.shopping.persistence.ParkingDAO;

public class ParkingServiceImpl implements ParkingService{

	private ParkingDAO dao;
	
	@Override
	public void ParkingModify(ParkingVO vo) throws Exception {
		dao.ParkingModify(vo);
	}
}
