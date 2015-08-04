package com.freestyle.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.NoticeFileDao;
import com.freestyle.web.dao.myBatis.MybatisNoticeDao;
import com.freestyle.web.dao.myBatis.MybatisNoticeFileDao;
import com.freestyle.web.vo.Notice;
import com.freestyle.web.vo.NoticeFile;

/*@WebServlet("/customer/noticeReg")*/
@MultipartConfig
(

fileSizeThreshold =1024*1024,
maxFileSize = 1024*1024*5, //5메가
maxRequestSize = 1024*1024*5*5//5메가 5개까지		
)
public class NoticeRegController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 NoticeDao noticeDao = new MybatisNoticeDao();	
		 List<Notice> list = noticeDao.getNotices();
		 request.setAttribute("list", list);
		 				 
		 if(request.getMethod().equals("POST"))
			{
			 	Part part = request.getPart("file");
			 	
			 	/*StringBuilder sb = new StringBuilder();
			 	sb.append("D:\\savefile");
			 	sb.append("");
			 	*/
			 	
			 	ServletContext application = request.getServletContext();
			 	String url = "/resource/customer/upload";	
			 	String path = application.getRealPath(url);
			 			 	
			 	String temp = part.getSubmittedFileName();
			 	String fname = temp.substring(temp.lastIndexOf("\\")+1);
			 	String fpath = path +"\\"+ fname;
			 	
			 	response.getWriter().println(fpath);
				
			 	InputStream ins = part.getInputStream();
			 	OutputStream outs = new FileOutputStream(fpath);
			 	
			 	byte[] dy = new byte[1024];
			 	int len =0;
			 	
			 	while( (len = ins.read(dy,0,1024))>=0)
			 	outs.write(dy, 0, len);
			 	
			 	outs.flush();
			 	outs.close();
			 	ins.close();
			 	
				String title=request.getParameter("title");
				String file=request.getParameter("file");
				String content=request.getParameter("content");
				
				Notice notice = new Notice();
				NoticeFile noticeFile = new NoticeFile();
				
				notice.setTitle(title);
				notice.setWriter("cb34");
				notice.setContent(content);
				
				noticeDao = new MybatisNoticeDao();	
				noticeDao.addNotice(notice);
				
				
				NoticeFileDao noticeFileDao = new MybatisNoticeFileDao();
				noticeFile.setName(fname);
				noticeFile.setNoticeCode(noticeDao.getLastCode());
				noticeFileDao.addNoticeFile(noticeFile);
				
				response.sendRedirect("notice");
			}
		 else{
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
		 dispatcher.forward(request, response);
		 }
	}		 
}
