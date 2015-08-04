package com.freestyle.web.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.RedirectSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.freestyle.web.dao.MemberDao;
import com.freestyle.web.dao.NoticeDao;
import com.freestyle.web.dao.NoticeFileDao;
import com.freestyle.web.vo.Member;

public class NewlecAuthenticationSuccessHandler 
implements AuthenticationSuccessHandler{
	
	@Autowired
	private MemberDao memberDao;
	
/*	private MemberDao memberDao;

	//@Autowired∑Œ ∏≈«Œ«ÿ¡‹
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		String uid = authentication.getName();
		Member m = memberDao.getMember(uid);
		
		String type = m.getDefaultRole();
		
		//String targetUrl = "/mypage/index";
		String targetUrl = "/customer/notice";
		
		if(type.equals("ROLE_TEACHER"))
				targetUrl="/customer/noticeDetail?c=5";
		
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

}
