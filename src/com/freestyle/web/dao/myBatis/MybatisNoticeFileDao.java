package com.freestyle.web.dao.myBatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.NoticeFileDao;
import com.freestyle.web.vo.Notice;
import com.freestyle.web.vo.NoticeFile;

public class MybatisNoticeFileDao implements NoticeFileDao{

	//SqlSessionFactory factory = new SqlFreeStyleSessionFactory().getSqlSessionFactory();
	@Autowired
	private SqlSession session;

	@Override
	public int addNoticeFile(NoticeFile noticeFile) {
		//SqlSession session = factory.openSession();
		int result=0;
		try{
			NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
			result = dao.addNoticeFile(noticeFile);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;
	}


	@Override
	public List<NoticeFile> getNoticeFilesOfNotice(String code) {
		//SqlSession session = factory.openSession();
		/*List<NoticeFile> list = new ArrayList<NoticeFile>();
		NoticeFile file = new NoticeFile();
		file.setName(code+"의 파일1");
		list.add(file);
		
		file = new NoticeFile();
		file.setName(code+"의 파일2");
		list.add(file);*/
		NoticeFileDao dao = (NoticeFileDao)session.getMapper(NoticeFileDao.class);
		List<NoticeFile> list = dao.getNoticeFilesOfNotice(code); 
		session.close();
		
		return list;
		
	}


}
