package org.nulljump.dionysos.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	//사용자
	//공지사항 전체 목록 출력
	public ArrayList<Notice> selectAllList(){
		List<Notice> list = session.selectList("noticeMapper.selectAllList");
		
		return (ArrayList<Notice>)list;
	}
	
	//페이징처리 추가
	public ArrayList<Notice> selectList(Paging page) {
		
		List<Notice> list = session.selectList("noticeMapper.selectList", page);
		
		return (ArrayList<Notice>)list;
	}

	//공지사항 번호로 조회하기
	public Notice selectNotice(int notice_no) {
		
		return session.selectOne("noticeMapper.selectNotice", notice_no);
	}

	//제목으로 검색
	public ArrayList<Notice> selectSearchTitle(String title) {
		
		List<Notice> list = session.selectList("noticeMapper.selectSearchTitle", title);
		
		return (ArrayList<Notice>)list;
	}
	
	//날짜로 검색
	public ArrayList<Notice> selectSearchDate(SearchDate date) {
		
		List<Notice> list = session.selectList("noticeMapper.selectSearchDate", date);
		
		return (ArrayList<Notice>)list;
	}

	//조회수 1증가 처리용
	public int addReadCount(int notice_no) {
		
		return session.update("noticeMapper.addReadCount", notice_no);
	}
	

	//관리자
	//공지사항 등록
	public int insertNotice(Notice notice) {
		
		return session.insert("noticeMapper.insertNotice", notice);
	}
	
	//공지사항 수정
	public int updateNotice(Notice notice) {
		
		return session.update("noticeMapper.updateNotice", notice);
	}
	
	//공지사항 삭제
	public int deleteNotice(int notice_no) {

		return session.delete("noticeMapper.deleteNotice", notice_no);
	}
	
		
	//전체 게시글 목록 갯수 가져오기 ()
	public int getListCount() {

		return session.selectOne("noticeMapper.getListCount");
	}
	
	

}
