package com.freestyle.web.vo;

import java.util.Date;
import java.util.List;

import com.freestyle.web.dao.NoticeFileDao;
import com.freestyle.web.dao.myBatis.MybatisNoticeFileDao;

public class Notice {
	private String code;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int hit;
	//-------------------------------------
	private String writerName;
	private int cmtCount;
	
	private List<NoticeFile> files;
	
	
	
	/*public List<NoticeFile> getFiles(){
		NoticeFileDao fileDao = new MybatisNoticeFileDao();
		return fileDao.getNoticeFilesOfNotice(this.code);
	}*/
	
	public List<NoticeFile> getFiles() {
		return files;
	}
	public void setFiles(List<NoticeFile> files) {
		this.files = files;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}