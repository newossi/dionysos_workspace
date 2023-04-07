package org.nulljump.dionysos.notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{

	private static final long serialVersionUID = 2939197864718510843L;
	
	private int notice_no;
	private String title;
	private String content;
	private java.sql.Date created_at;
	private String notice_original_filename;
	private String notice_rename_filename;
	private int read_count;
	private String user_id;
	
	public Notice () {}
	
	public Notice(int notice_no, String title, String content, Date created_at, String notice_original_filename,
			String notice_rename_filename, int read_count, String user_id) {
		super();
		this.notice_no = notice_no;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.notice_original_filename = notice_original_filename;
		this.notice_rename_filename = notice_rename_filename;
		this.read_count = read_count;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", title=" + title + ", content=" + content + ", created_at="
				+ created_at + ", notice_original_filename=" + notice_original_filename + ", notice_rename_filename="
				+ notice_rename_filename + ", read_count=" + read_count + ", user_id=" + user_id + "]";
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(java.sql.Date created_at) {
		this.created_at = created_at;
	}

	public String getNotice_original_filename() {
		return notice_original_filename;
	}

	public void setNotice_original_filename(String notice_original_filename) {
		this.notice_original_filename = notice_original_filename;
	}

	public String getNotice_rename_filename() {
		return notice_rename_filename;
	}

	public void setNotice_rename_filename(String notice_rename_filename) {
		this.notice_rename_filename = notice_rename_filename;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
