package com.freestyle.web.controller.joinus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freestyle.web.dao.MemberDao;
import com.freestyle.web.dao.myBatis.MybatisMemberDao;
import com.freestyle.web.vo.Member;

@WebServlet("/joinus/login")
public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 				 
		 if(request.getMethod().equals("POST"))
			{				 	
				String uid=request.getParameter("uid");
				String pwd=request.getParameter("pwd");
				
				MemberDao  memberdao = new MybatisMemberDao();
				Member member =memberdao.getMember(uid);
				
				if(member == null)
				{
					request.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
				}
				else if(!member.getPwd().equals(pwd))
				{
					request.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("uid", uid);
					response.sendRedirect("../customer/notice");
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				 dispatcher.forward(request, response);
			}
		 else{
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
			 dispatcher.forward(request, response);
		 }
		 
		
		 
	}

}
