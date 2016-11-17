package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void create(Long no){
		sqlSession.insert("blog.insert",no);
	}
	
	public BlogVo index(Long no){
		return sqlSession.selectOne("blog.index",no);
	}
	
	// *********** 기본 수정  ***************
	
	public void basicModify(BlogVo blogvo){
		sqlSession.update("blog.basicModify",blogvo);
	}
	
	public void onlyTitle(BlogVo blogvo){
		sqlSession.update("blog.onlyTitle",blogvo);
	}
	
	// ********** 카테고리 수정 **************
	
	public void add_category(CategoryVo categoryVo){
		sqlSession.insert("blog.addCategory",categoryVo);
	}
	
	public void delete_category(CategoryVo categoryVo){
		sqlSession.delete("blog.deleteCategory",categoryVo);
	}
}
