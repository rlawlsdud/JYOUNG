package com.freestyle.web.dao.myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.vo.Notice;

public class MybatisNoticeDao implements NoticeDao{

	//SqlSessionFactory factory = new SqlFreeStyleSessionFactory().getSqlSessionFactory();
	@Autowired
	private SqlSession session;
	
	
	/*@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}*/

	@Override
	public List<Notice> getNotices() {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getNotices(1,"title","");
	}

	@Override
	public List<Notice> getNotices(int page) {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getNotices(page,"title","");
		//session.close();
	}

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getNotices(page, field, query);
	}

	@Override
	public int addNotice(Notice notice) {
		//SqlSession session = factory.openSession();
		int result=0;
		try{	
		NoticeDao dao = session.getMapper(NoticeDao.class);
		result=dao.addNotice(notice);
		//session.commit();
		return dao.addNotice(notice);
		}
		finally{
			//session.rollback();
			//session.close();
		}
	}
	
	@Override
	public Notice getNotice(String code) {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getNotice(code);
	}

	@Override
	public List<Notice> getNotices(int page, String field) {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getNotices(page,"title","");
	}

	@Override
	public String getLastCode() {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getLastCode();
	}

	
	
	

}
