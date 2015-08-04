package com.freestyle.web.dao;

import java.util.List;

import com.freestyle.web.vo.Notice;



public interface NoticeDao 	{
	
	
	public List<Notice> getNotices();
	public List<Notice> getNotices(int page);
	public List<Notice> getNotices(int page, String field);
	public List<Notice> getNotices(int page, String field, String query);
	public Notice getNotice(String code);
	
	public int addNotice(Notice notice);
	public String getLastCode();
}
