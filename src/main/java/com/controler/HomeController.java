package com.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService service;

	@RequestMapping("/")
	public String HomePage() {

		return "/views/index.jsp";
	}

	@RequestMapping("/upload")
	public String HomePage1(MultipartFile file) {
		service.chek(file);
		return "/views/done.jsp";
	}

}
