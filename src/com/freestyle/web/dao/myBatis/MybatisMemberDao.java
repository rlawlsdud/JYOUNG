package com.freestyle.web.dao.myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.freestyle.web.dao.MemberDao;
import com.freestyle.web.vo.Member;


public class MybatisMemberDao implements MemberDao{

	//SqlSessionFactory factory = new SqlFreeStyleSessionFactory().getSqlSessionFactory();
	@Autowired
	private SqlSession session;
	
	@Override
	public Member getMember(String uid) {
		//SqlSession session = factory.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		return dao.getMember(uid);	
		
	}

}
