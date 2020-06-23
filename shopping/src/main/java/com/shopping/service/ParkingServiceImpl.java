package com.shopping.service;

import java.util.List;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 69a8419d75f08e845899b94b5786257128620fc0
import javax.inject.Inject;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.shopping.domain.ParkingVO;
import com.shopping.persistence.ParkingDAO;

@Service
public class ParkingServiceImpl implements ParkingService{

	@Inject
=======
>>>>>>> 69a8419d75f08e845899b94b5786257128620fc0
import com.shopping.domain.ParkingVO;
import com.shopping.persistence.ParkingDAO;

@Service
public class ParkingServiceImpl implements ParkingService{

<<<<<<< HEAD
	@Inject
=======
>>>>>>> 434614a8508ad7801bb6f9547ad2333907be0b6c
>>>>>>> 69a8419d75f08e845899b94b5786257128620fc0
	private ParkingDAO dao;
	
	@Override
	public void ParkingModify(ParkingVO vo) throws Exception {
		dao.ParkingModify(vo);
	}

	@Override
	public List<ParkingVO> showLocateList() throws Exception {
		return dao.showLocateList();
	}
}
