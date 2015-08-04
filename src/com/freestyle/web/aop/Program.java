package com.freestyle.web.aop;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.myBatis.SqlFreeStyleSessionFactory;
import com.freestyle.web.vo.Notice;

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
		
		//NoticeDao noticeDao = new MybatisNoticeDao();
		/*NoticeDao proxy = (NoticeDao)Proxy.newProxyInstance(
				noticeDao.getClass().getClassLoader(),
				noticeDao.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					
					
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("사전");
						List<Notice> list = (List<Notice>) method.invoke(noticeDao, args);
						System.out.println("사후");
						
						return list;
					}
				});*/
				
		ApplicationContext context = new ClassPathXmlApplicationContext("com/freestyle/web/aop/SpringContext.xml");
		
		NoticeDao noticeDao = (NoticeDao) context.getBean("noticeDao");
	
		List<Notice> list = noticeDao.getNotices();
		Notice notice = noticeDao.getNotice("5");
		
		for(Notice n : list)
		 System.out.printf("제목 : %s\n", n.getTitle());
		
	}

}
