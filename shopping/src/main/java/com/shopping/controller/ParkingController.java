package com.shopping.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.domain.ParkingVO;
import com.shopping.service.ParkingService;

@Controller
@RequestMapping("/parking/*")
public class ParkingController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	ParkingService parkingService;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Map<String, Object> selectLocate() throws Exception {
		logger.info("show");

		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyLocate(ParkingVO vo, HttpServletRequest request) throws Exception {
		logger.info("modify parking");
		
		String locate =request.getParameter("locate");
		String isUse =request.getParameter("isUse");
		
		vo.setCheck(isUse);
		vo.setlocate(locate);
		
		parkingService.ParkingModify(vo);
	}
}
