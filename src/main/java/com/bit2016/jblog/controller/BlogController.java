package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.service.PostService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.PostVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;
	
	@RequestMapping("")
	public String index(@AuthUser UserVo userVo,Model model,
						@RequestParam(value="no",required=true,defaultValue="")Long no){
		
		BlogVo blogVo=blogService.index(no);
		List<CategoryVo> list =categoryService.getList(userVo);
		
		model.addAttribute("blogVo",blogVo);
		model.addAttribute("category",list);
		
		return "blog/blog-main";
	}
	
	
	// ***************  관리    페이지	*******  기본 관리	 **********************
	
	
	@Auth
	@RequestMapping("/admin")
	public String admin(@AuthUser UserVo authUser,@ModelAttribute BlogVo blogVo,Model model){
		model.addAttribute("authUser", authUser);
		model.addAttribute("blogVo",blogVo);
		
		return "blog/blog-admin-basic";
	}
	
	@Auth
	@RequestMapping("/basic_admin")
	public String basicModify(@AuthUser UserVo authUser,
							  @RequestParam(value="title",required=true,defaultValue="타이틀 없음") String blogName,
							  @RequestParam(value="logo-file") MultipartFile file, 
							  @ModelAttribute BlogVo blogVo){
		
		blogVo.setNo(authUser.getNo());
		blogService.basicModify(blogVo,file,blogName);
		
		return "blog/blog-main";
	}
	
	
	// ***************  관리    페이지	*******  카테고리 관리	 **********************	
	
	
	@Auth
	@RequestMapping("/admin_category")
	public String admin_category(@AuthUser UserVo authUser,@ModelAttribute BlogVo blogVo,Model model){
		List<CategoryVo> list=categoryService.getList(authUser);
		model.addAttribute("list", list);
		return "blog/blog-admin-category";
	}

	@Auth
	@RequestMapping("/admin_addcategory")
	public String add_category(@AuthUser UserVo authUser,
							   @RequestParam(value="name",required=true,defaultValue="이름 설정 없음") String categoryName,
							   @RequestParam(value="desc",required=true,defaultValue="표기 없음") String description,
							   @ModelAttribute CategoryVo categoryVo){
		blogService.add_category(authUser,categoryName,categoryVo,description);
		return "blog/blog-main";
		}
	
	@Auth
	@RequestMapping("/admin_deletecategory")
	public String delete_category(@AuthUser UserVo authUser,
								  @RequestParam(value="no",required=true,defaultValue="") Long no,
								  @ModelAttribute CategoryVo categoryVo){
		blogService.delete_category(categoryVo,no,authUser.getNo());
		return "blog/blog-main";
	}
	
	// ***************  관리    페이지	*******  게시글 관리	 **********************
	
	
	@Auth
	@RequestMapping("/admin_write")
	public String admin_write(@AuthUser UserVo authUser,@ModelAttribute BlogVo blogVo,Model model){
		
		List<CategoryVo> list=categoryService.getList(authUser);
		model.addAttribute("list", list);
		
		return "blog/blog-admin-write";
	}
	@Auth
	@RequestMapping("/post")
	public String post(@ModelAttribute PostVo postVo){
		System.out.println(postVo);
		postService.post(postVo);
		
		return "blog/blog-main";
	}
	
}
