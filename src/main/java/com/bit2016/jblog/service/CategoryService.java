package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> getList(UserVo userVo){
		return categoryDao.getList(userVo);
	}
	
}
