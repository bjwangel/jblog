package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.UserVo;

@Service
public class UserService {
	BlogVo blogVo =new BlogVo();
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public void join(UserVo vo){
		userDao.join(vo);
		blogDao.create(userDao.getNo(vo));
	}
	
	public UserVo login(UserVo vo){
		return userDao.login(vo);
	}
}
