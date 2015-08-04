package com.freestyle.web.dao;

import java.util.List;

import com.freestyle.web.vo.NoticeFile;

public interface NoticeFileDao {
	public int addNoticeFile(NoticeFile noticeFile);
	
	public List<NoticeFile> getNoticeFilesOfNotice(String code);
}
