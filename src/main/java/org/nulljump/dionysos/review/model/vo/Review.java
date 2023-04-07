package org.nulljump.dionysos.review.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable{

	private static final long serialVersionUID = -791391879282332652L;

	private int review_id;        	//리뷰 번호
	private String user_id;       	//리뷰 작성자 아이디
	private int product_id;       	//상품 번호
	private String review_title;  	//리뷰 제목
	private String review_content;	//리뷰 내용
	private String review_image;    //첨부파일 이미지
	private String review_score;  	//리뷰 점수
	private Date created_at;    	//리뷰 등록일자
	private Date modified_at;     	//리뷰 수정일자
	private int read_count;         //조회수
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int review_id, String user_id, int product_id, String review_title, String review_content,
			String review_image, String review_score, Date created_at, Date modified_at, int read_count) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_image = review_image;
		this.review_score = review_score;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.read_count = read_count;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_image() {
		return review_image;
	}

	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}

	public String getReview_score() {
		return review_score;
	}

	public void setReview_score(String review_score) {
		this.review_score = review_score;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", user_id=" + user_id + ", product_id=" + product_id
				+ ", review_title=" + review_title + ", review_content=" + review_content + ", review_image="
				+ review_image + ", review_score=" + review_score + ", created_at=" + created_at + ", modified_at="
				+ modified_at + ", read_count=" + read_count + "]";
	}

}
