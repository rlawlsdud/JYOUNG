package com.freestyle.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int x=0;
		int y=0;
		int result=0;
		
		String _result = request.getParameter("result");
		
		if(_result !=null)
		{
			result = Integer.parseInt(_result);
		}
		
		if(request.getMethod().equals("POST")){
		
			String _btn = request.getParameter("btn");
			
			
			if(_btn.equals("Application"))
			{
				ServletContext application = request.getServletContext();
				application.setAttribute("a", result);
				out.write("<p>application�� ���� �Ϸ�</p>");
				
			}
			else if(_btn.equals("Session"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("s", result);
				out.write("<p>session�� ���� �Ϸ�</p>");
				
			}
			else if(_btn.equals("Cookie"))
			{
				Cookie cookie = new Cookie("c", String.valueOf(result));
				cookie.setMaxAge(24*60*60);//24�ð�
				response.addCookie(cookie);
				
				out.write("<p>cookie�� ���� �Ϸ�</p>");
			}
			
			else
			{
				String _x = request.getParameter("x");
				String _y = request.getParameter("y");
					
				if(_x !=null && !_x.isEmpty() &&_y !=null && !_y.isEmpty())
				{
					x = Integer.parseInt(_x);
					y = Integer.parseInt(_y);
				}
				result = x+y;
			}
		}
		out.write("<form action = \"add\" method=\"post\">");
		out.write("<ul>");
		out.write("	<li><label for=\"x\"> X:</label><input name=\"x\"/></li>");
		out.write("	<li><label for=\"y\"> Y:</label><input name=\"y\"/></li>");
		out.write("</ul>");
		out.write("<p>");
		out.printf("<input type=\"hidden\" name=\"result\" value=\"%d\"/>", result);
		out.write("<input type=\"submit\" name=\"btn\" value=\"����\"/>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"Application\"/>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"Session\"/>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"Cookie\"/>");
		out.write("</p>");
		out.write("</form>");
		out.printf("add ��������� :%d<br /> " , result);
		out.println("<a href=\"Mypage\">����������</a>");
    }	
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
		
	}

	

}
