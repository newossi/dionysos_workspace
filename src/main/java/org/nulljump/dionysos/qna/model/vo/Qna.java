package org.nulljump.dionysos.qna.model.vo;

import java.sql.Date;

public class Qna implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private int qna_no;
	private String user_id;
	private String title;
	private String content;
	private java.sql.Date created_at;
	private int inquiry_type;    //문의유형 
	private int inquiry_state;   //문의상태 
	private String qna_original_filename;
	private String qna_rename_filename;
	private int qna_ref;      //원글번호 : 원글 - 자기번호, 댓글 : 원글번호
	private int qna_reply_ref;     //원글 : null, 원글의 답/댓글 : 자기번호
	private int qna_lev;       //원글 : 1, 원글의 답글 : 2
	private int qna_reply_seq;     //원글 : 0, 같은 원글의 답글일 때 : 1 ...순차처리
	private java.sql.Date answered_at;
	
	public Qna() {}
	
	public Qna(int qna_no, String user_id, String title, String content, Date created_at, int inquiry_type,
			int inquiry_state, String qna_original_filename, String qna_rename_filename, int qna_ref, int qna_reply_ref,
			int qna_lev, int qna_reply_seq, Date answered_at) {
		super();
		this.qna_no = qna_no;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.inquiry_type = inquiry_type;
		this.inquiry_state = inquiry_state;
		this.qna_original_filename = qna_original_filename;
		this.qna_rename_filename = qna_rename_filename;
		this.qna_ref = qna_ref;
		this.qna_reply_ref = qna_reply_ref;
		this.qna_lev = qna_lev;
		this.qna_reply_seq = qna_reply_seq;
		this.answered_at = answered_at;
	}


	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", user_id=" + user_id + ", title=" + title + ", content=" + content
				+ ", created_at=" + created_at + ", inquiry_type=" + inquiry_type + ", inquiry_state=" + inquiry_state
				+ ", qna_original_filename=" + qna_original_filename + ", qna_rename_filename=" + qna_rename_filename
				+ ", qna_ref=" + qna_ref + ", qna_reply_ref=" + qna_reply_ref + ", qna_lev=" + qna_lev
				+ ", qna_reply_seq=" + qna_reply_seq + ", answered_at=" + answered_at + "]";
	}


	public int getQna_no() {
		return qna_no;
	}


	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
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


	public int getInquiry_type() {
		return inquiry_type;
	}


	public void setInquiry_type(int inquiry_type) {
		this.inquiry_type = inquiry_type;
	}


	public int getInquiry_state() {
		return inquiry_state;
	}


	public void setInquiry_state(int inquiry_state) {
		this.inquiry_state = inquiry_state;
	}


	public String getQna_original_filename() {
		return qna_original_filename;
	}


	public void setQna_original_filename(String qna_original_filename) {
		this.qna_original_filename = qna_original_filename;
	}


	public String getQna_rename_filename() {
		return qna_rename_filename;
	}


	public void setQna_rename_filename(String qna_rename_filename) {
		this.qna_rename_filename = qna_rename_filename;
	}


	public int getQna_ref() {
		return qna_ref;
	}


	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}


	public int getQna_reply_ref() {
		return qna_reply_ref;
	}


	public void setQna_reply_ref(int qna_reply_ref) {
		this.qna_reply_ref = qna_reply_ref;
	}


	public int getQna_lev() {
		return qna_lev;
	}


	public void setQna_lev(int qna_lev) {
		this.qna_lev = qna_lev;
	}


	public int getQna_reply_seq() {
		return qna_reply_seq;
	}


	public void setQna_reply_seq(int qna_reply_seq) {
		this.qna_reply_seq = qna_reply_seq;
	}


	public java.sql.Date getAnswered_at() {
		return answered_at;
	}


	public void setAnswered_at(java.sql.Date answered_at) {
		this.answered_at = answered_at;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
