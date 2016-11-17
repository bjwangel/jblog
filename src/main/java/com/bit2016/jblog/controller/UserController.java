package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/join")
	public String joinform(){
		return "user/join";
	}
	
	@RequestMapping("/joinsuccess")
	public String join(@ModelAttribute UserVo vo){
		
		userService.join(vo);
		
		return "user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String login(){
		return "user/login";
	}
	
}
