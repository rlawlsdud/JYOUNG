package com.freestyle.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.myBatis.MybatisNoticeDao;
import com.freestyle.web.vo.Notice;


public class SpringNoticeController implements Controller{
//������ 2.5 ���� ����	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		NoticeDao noticeDao = new MybatisNoticeDao();	
		 List<Notice> list = noticeDao.getNotices();
		 
		 
		 //��Ʈ�ѷ� ����
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		 mv.addObject("list", list);
		 return mv;
		 
		 /*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		 dispatcher.forward(request, response);*/
		
		 
	}		 
}
