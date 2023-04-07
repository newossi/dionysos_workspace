package org.nulljump.dionysos.faq.model.vo;

import java.sql.Date;

public class Faq implements java.io.Serializable{

	private static final long serialVersionUID = -1996866164730996735L;
	
	private int faq_no;
	private String question;
	private String answer;
	private java.sql.Date registration_date;
	private String user_id;
	private int views;
	
	public Faq() {}
	
	public Faq(String question, String answer, int faq_no, Date registration_date, String user_id, int views) {
		super();
		this.question = question;
		this.answer = answer;
		this.faq_no = faq_no;
		this.registration_date = registration_date;
		this.user_id = user_id;
		this.views = views;
	}

	@Override
	public String toString() {
		return "Faq [question=" + question + ", answer=" + answer + ", faq_no=" + faq_no + ", registration_date="
				+ registration_date + ", user_id=" + user_id + ", views=" + views + "]";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public java.sql.Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(java.sql.Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
	
	