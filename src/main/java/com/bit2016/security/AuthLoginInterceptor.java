package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserVo userVo= new UserVo();
		userVo.setId(request.getParameter("id"));
		userVo.setPassword(request.getParameter("password"));
		// 입력 받은값 UserVo 에 저장했고...
		
		ApplicationContext ac= WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		UserService userService=ac.getBean(UserService.class);
		
		UserVo userVo2=userService.login(userVo);
		
		if(userVo2==null){
			response.sendRedirect(request.getContextPath()+"jblog/user/loginform?result=fail");
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo2);
		
		response.sendRedirect(request.getContextPath());
		
		return false;
	}
	
}
