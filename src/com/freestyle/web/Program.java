package com.freestyle.web;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.freestyle.web.dao.myBatis.SqlFreeStyleSessionFactory;


public class Program {

	static{
		SqlFreeStyleSessionFactory factory = new SqlFreeStyleSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		//List<Notice> list = new MybatisNoticeDao().getNotices();
		
		/*NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list  =noticeDao.getNotices();
		
		for(Notice n : list){
			System.out.println("title: "+ n.getTitle());
		}*/
/*		NoticeDao noticeDao = new MybatisNoticeDao();
		NoticeConsole console = new NoticeConsole();
		console.setNoticeDao(noticeDao);*/
		
		/*NoticeConsole console = ctx.getBean(**);
		console.print();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/freestyle/web/SpringContext.xml");
		
		NoticeConsole console = (NoticeConsole) context.getBean("console");
		console.print();
	}

}
