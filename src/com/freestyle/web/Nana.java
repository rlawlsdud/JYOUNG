package com.freestyle.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/hello")
public class Nana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		
		String _cnt = request.getParameter("cnt"); 
		int cnt = 5;
		if(_cnt !=null && _cnt.equals("")){
			cnt = Integer.parseInt(_cnt);
		}
		PrintWriter out = response.getWriter();
		
		for(int i=0; i<cnt; i++){
		out.println((i+1)+ ": ¾È³ç<br />");
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x=0;
		int y=0;
		
		if(_x !=null && !_x.equals("") &&_y !=null && !_y.equals("")){
			x = Integer.parseInt(_x);
			y = Integer.parseInt(_y);
		}
		
		int result = x+y;	

		PrintWriter out=response.getWriter();
		
		out.write("<form action = \"hello\" method=\"post\">");
		out.write("<ul>");
		out.write("	<li><label for=\"x\"> X:</label><input name=\"x\"/></li>");
		out.write("	<li><label for=\"y\"> Y:</label><input name=\"y\"/></li>");
		out.write("</ul>");
		out.write("<p><input type=\"submit\" value=\"µ¡¼À\"/></p>");
		out.write("</form>");
		
		
		out.println("µ¡¼À°á°ú´Â : " + result);
	}

	

}
