package com.freestyle.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.myBatis.MybatisNoticeDao;
import com.freestyle.web.vo.Notice;

/*@WebServlet("/customer/notice")*/
public class NoticeController extends HttpServlet{

	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 NoticeDao noticeDao = new MybatisNoticeDao();	
		 List<Notice> list = noticeDao.getNotices();
		 request.setAttribute("list", list);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		 dispatcher.forward(request, response);
	}		 
}
