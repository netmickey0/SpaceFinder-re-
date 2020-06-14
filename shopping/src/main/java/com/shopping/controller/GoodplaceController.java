package com.shopping.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.domain.GoodPVO;
import com.shopping.domain.GpCategoryVO;
import com.shopping.service.GpService;
import com.shopping.utils.MultiFiles;
import com.shopping.utils.UploadFileUtils;

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
	public void getGoodpRegister(Model model) throws Exception {
		logger.info("get gp category");

		List<GpCategoryVO> catelist = gpService.cateList();

		model.addAttribute("catelist", catelist);
	}

	// 주차장 등록
	@RequestMapping(value = "/gpReg", method = RequestMethod.POST)
	public String postGoodpRegister(GoodPVO vo, MultiFiles multiFiles, HttpServletRequest req) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		int i=0;
		for (MultipartFile file : multiFiles.getGP_image()) {
			if (file != null) {
				fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
						ymdPath);
			} else {
				fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			}
			switch(i) {
			case 0:
				vo.setGP_image1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg1(
						File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				break;
			case 1:
				vo.setGP_image2(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg2(
						File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				break;
			case 2:
				vo.setGP_image3(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg3(
						File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				break;
			case 3:
				vo.setGP_image4(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg4(
						File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				break;
			}
			i++;
		}

		String runtime = "평일 : " + req.getParameter("weekday_on_time") + " ~ " + req.getParameter("weekday_close_time")
				+ "/" + "주말(휴일) : " + req.getParameter("weekend_on_time") + " ~ "
				+ req.getParameter("weekend_close_time");
		vo.setGP_Runtime(runtime);


		gpService.GP_reg(vo);

		return "redirect:/goodplace/main";
	}

}
