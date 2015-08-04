package com.freestyle.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.NoticeFileDao;
import com.freestyle.web.vo.Notice;
import com.freestyle.web.vo.NoticeFile;

@Controller //컨트롤러 임을 알려줌
@RequestMapping("/customer/*")
public class CustomerController {

	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;

	//@Autowired로 매핑해줌
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Autowired	
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	


	@RequestMapping("notice")
	public String notice(Model model){
		//NoticeDao noticeDao = new MybatisNoticeDao();	
		 List<Notice> list = noticeDao.getNotices();
				 
		 //컨트롤러 생성
		/* ModelAndView mv = new ModelAndView();
		 mv.setViewName("/WEB-INF/view/customer/notice.jsp");*/
		 model.addAttribute("list", list);
		 return "customer.notice";
	}
	
	@RequestMapping(value="noticeDetail")
	public String noticeDetail(String c, Model model){
		//NoticeDao noticeDao = new MybatisNoticeDao();	
		 Notice n = noticeDao.getNotice(c);
				 
		 //컨트롤러 생성
		/* ModelAndView mv = new ModelAndView();
		 mv.setViewName("/WEB-INF/view/customer/notice.jsp");*/
		 model.addAttribute("n",n);
		 return "customer.noticeDetail";
	}
	
	@RequestMapping(value="noticeReg", method=RequestMethod.GET)
	public String noticeReg(){
		//return "/WEB-INF/view/customer/noticeReg.jsp";
		return "customer.noticeReg";
	}
	
	@RequestMapping(value="noticeReg", method=RequestMethod.POST)
	public String noticeReg(Notice notice, MultipartFile file, Principal principal ,
			HttpServletRequest request, SecurityContext context,
			SecurityContextHolder holder
			) throws IOException{
		
		if(request.isUserInRole("ROLE_ADMIN"))
		{
			
		}
		
		//holder.getContext()
		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();
		
		notice.setWriter(principal.getName());
		noticeDao.addNotice(notice);
	 	String lastCode = noticeDao.getLastCode();
		//Part part = request.getPart("file");
	 	
	 	/*StringBuilder sb = new StringBuilder();
	 	sb.append("D:\\savefile");
	 	sb.append("");
	 	*/
	 	if(!file.isEmpty())
	 	{
	 	ServletContext application = request.getServletContext();
	 	String url = "/resource/customer/upload";	
	 	String path = application.getRealPath(url);
	 			 	
	 	String temp = file.getOriginalFilename();//실제 파일명 //part.getSubmittedFileName();
	 	String fname = temp.substring(temp.lastIndexOf("\\")+1);
	 	String fpath = path +"\\"+ fname;
	 	
		
	 	InputStream ins = file.getInputStream();//part.getInputStream();
	 	OutputStream outs = new FileOutputStream(fpath);
	 	
	 	byte[] dy = new byte[1024];
	 	int len =0;
	 	
	 	while( (len = ins.read(dy,0,1024))>=0)
	 	outs.write(dy, 0, len);
	 	
	 	outs.flush();
	 	outs.close();
	 	ins.close();
	 	
	 	NoticeFile noticeFile = new NoticeFile();
	 	noticeFile.setNoticeCode(lastCode);
	 	noticeFile.setName(fname);
	 	noticeFileDao.addNoticeFile(noticeFile);
	 	}
	 
		return "redirect:notice";
		
	}
	
}
