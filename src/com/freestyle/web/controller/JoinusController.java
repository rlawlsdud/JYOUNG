package com.freestyle.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //��Ʈ�ѷ� ���� �˷���
@RequestMapping("/joinus/*")
public class JoinusController {
	
	@RequestMapping("login")
	public String login()
	{
		 return "/WEB-INF/view/joinus/login.jsp";
	}
}
