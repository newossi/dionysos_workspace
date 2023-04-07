package org.nulljump.dionysos.review.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.review.model.vo.Review;

public interface ReviewService { 
	ArrayList<Review> selectReviewList(Paging page);     //리뷰 목록 조회
	Review selectReview(int review_id);      //리뷰 조회
	int insertReview(Review review);   		 //리뷰 추가
	int updateReview(Review review);         //리뷰 수정
	int deleteReview(Review review);    	//리뷰 삭제  
	int getListCount();                     //리뷰 목록의 총 갯수를 조회
	int updateReviewReadcount(int review_id); //상세보기시 조회수 1증가 처리용
}
