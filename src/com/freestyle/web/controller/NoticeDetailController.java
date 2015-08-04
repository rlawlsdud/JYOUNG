package com.freestyle.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.myBatis.MybatisNoticeDao;
import com.freestyle.web.vo.Notice;

/*@WebServlet("/customer/noticedetail")*/
public class NoticeDetailController extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		HttpSession session = request.getSession();
		if(session.getAttribute("uid")==null)
		
		response.sendRedirect("notice?error=1");
		
		NoticeDao noticeDao = new MybatisNoticeDao();

		String code = request.getParameter("c");
		
		Notice n = noticeDao.getNotice(code);
		
		request.setAttribute("n", n);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeDetail.jsp");
		dispatcher.forward(request, response);
	
		
	}
}
