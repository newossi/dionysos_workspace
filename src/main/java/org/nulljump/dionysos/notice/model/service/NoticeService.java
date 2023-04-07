package org.nulljump.dionysos.notice.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.notice.model.vo.Notice;

public interface NoticeService {
	
	//공지사항 전체 목록 출력
	ArrayList<Notice> selectAllList();
	
	//페이징처리 추가
	ArrayList<Notice> selectList(Paging page);
	
	//공지사항 번호로 조회하기
	Notice selectNotice(int notice_no);
	
	//제목으로 검색
	ArrayList<Notice> selectSearchTitle(String title);
	
	//날짜로 검색
	ArrayList<Notice> selectSearchDate(SearchDate date);
	
	//조회수 1증가 처리용
	int addReadCount(int notice_no);
	
	//공지사항 등록
	int insertNotice(Notice notice);
	
	//공지사항 수정
	int updateNotice(Notice notice);
	
	//공지사항 삭제
	int deleteNotice(int notice_no);
	
	//전체 게시글 목록 갯수 가져오기
	int getListCount();
	

		

}
