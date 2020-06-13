package com.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shopping.domain.GpCategoryVO;
import com.shopping.service.GpService;

@Controller
@RequestMapping("/goodplace")
public class GoodplaceController {

	private static final Logger logger = LoggerFactory.getLogger(GoodplaceController.class);

	@Inject
	GpService gpService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 카테고리 리스트
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void getCategory(Model model) throws Exception {
		logger.info("get gp category");

		List<GpCategoryVO> catelist = gpService.cateList();

		model.addAttribute("catelist", catelist);
	}

	// 카테고리 리스트
	@RequestMapping(value = "/gpReg", method = RequestMethod.GET)
	public void getGpCategory(Model model) throws Exception {
		logger.info("get gp category");

		List<GpCategoryVO> catelist = gpService.cateList();

		model.addAttribute("catelist", catelist);
	}

}
