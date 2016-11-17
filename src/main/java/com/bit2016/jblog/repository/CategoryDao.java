package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> getList(UserVo userVo){
		System.out.println(sqlSession.selectList("category.getList",userVo));
		return sqlSession.selectList("category.getList",userVo);
	}
}
