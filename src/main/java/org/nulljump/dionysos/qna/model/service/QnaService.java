package org.nulljump.dionysos.qna.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.qna.model.vo.Qna;


public interface QnaService {
	
	// 1:1문의 전체 목록 출력
	ArrayList<Qna> selectAllList();
	
	//한 페이지에 출력할 게시글 조회용
	ArrayList<Qna> selectList(Paging page);
	
	//해당 게시글 번호에 대한 게시글 상세 조회용
	Qna selectQna(int qna_no);
	
	// 제목으로 검색
	ArrayList<Qna> selectTitleSearch(String title);
	
	// 사용자 아이디로 검색
	ArrayList<Qna> selectIdSearch(String user_id);
	
	// 날짜로 검색
	ArrayList<Qna> selectDateSearch(SearchDate date);
	
	//원글 등록용
	int insertInquiry(Qna qna);
	
	//원글 수정용
	int updateInquiry(Qna qna);
	
	//게시글 삭제용(원글 삭제시 관련 댓글 같이 삭제)
	int deleteInquiry(Qna qna);
	
	//댓글 등록용
	int insertReply(Qna reply);
	
	//댓글 수정용
	int updateReply(Qna reply);
	
	// 답변 삭제
	int deleteReply(Qna reply);
	
		
	//총 게시글 갯수 조회용 (페이지 수 계산용)
	int selectListCount();
	

	//댓글 등록시 기존 댓글의 순번을 1증가 처리(최신 댓글이 순번 1이 되게함)
	int updateReplySeq(Qna reply);
		
	


}
