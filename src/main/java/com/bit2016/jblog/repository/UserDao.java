package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public void join(UserVo vo) {
		sqlSession.insert("user.insert", vo);
	}

	public long getNo(UserVo vo) {
		return sqlSession.selectOne("user.getno", vo);
	}

	public UserVo login(UserVo vo) {
		return sqlSession.selectOne("user.login", vo);
	}
}
