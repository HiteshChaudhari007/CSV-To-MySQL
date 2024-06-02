package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.StudentDao;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public void chek(MultipartFile file) {
		// TODO Auto-generated method stub
		dao.chek(file);

	}

}
