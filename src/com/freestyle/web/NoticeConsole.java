package com.freestyle.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.vo.Notice;



public class NoticeConsole {

	NoticeDao noticeDao;
	
	@Autowired
	@Resource(name="noticeDao1")
	//둘중 하나만 써도 가능
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void print()
	{
		//NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list  =noticeDao.getNotices();
				
		for(Notice n : list){
			System.out.println("title: "+ n.getTitle());
		}
	}

}
