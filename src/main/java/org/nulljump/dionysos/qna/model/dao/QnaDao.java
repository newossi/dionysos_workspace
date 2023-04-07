package org.nulljump.dionysos.qna.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.qna.model.vo.Qna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("qnaDao")
public class QnaDao {

	@Autowired
	private SqlSessionTemplate session;

	// 사용자
	// 1:1문의 전체 목록 출력
	public ArrayList<Qna> selectAllList() {
		List<Qna> list = session.selectList("qnaMapper.selectAllList");

		return (ArrayList<Qna>) list;
	}

	// 페이징처리 추가
	public ArrayList<Qna> selectList(Paging page) {
		List<Qna> list = session.selectList("qnaMapper.selectList", page);

		return (ArrayList<Qna>) list;
	}

	// 1:1문의 상세보기 
	public Qna selectQna(int qna_no) {

		return session.selectOne("qnaMapper.selectQna", qna_no);
	}

	// 제목으로 검색
	public ArrayList<Qna> selectTitleSearch(String title) {
		List<Qna> list = session.selectList("qnaMapper.selectTitleSearch", title);
		
		return (ArrayList<Qna>)list;
	}

	// 사용자 아이디로 검색
	public ArrayList<Qna> selectIdSearch(String user_id) {
		List<Qna> list = session.selectList("qnaMapper.selectIdSearch", user_id);
		
		return (ArrayList<Qna>)list;
	}

	// 날짜로 검색
	public ArrayList<Qna> selectDateSearch(SearchDate date) {
		List<Qna> list = session.selectList("qnaMapper.selectDateSearch", date);
		
		return (ArrayList<Qna>)list;
	}
	
	
	// 1:1문의 등록
	public int insertInquiry(Qna qna) {
		
		return session.insert("qnaMapper.insertInquiry", qna);
	}

	// 1:1문의 수정
	public int updateInquiry(Qna qna) {
		
		return session.update("qnaMapper.updateInquiry", qna);
	}

	// 1:1문의 삭제
	public int deleteInquiry(Qna qna) {
		
		return session.delete("qnaMapper.deleteInquiry", qna);
	}

	// 관리자
	// 답변 등록
	public int insertReply(Qna reply) {
		
		return session.insert("qnaMapper.insertReply", reply);
	}

	// 답변 수정
	public int updateReply(Qna reply) {
		
		return session.update("qnaMapper.updateReply", reply);
	}

	// 답변 삭제
	public int deleteReply(Qna reply) {
		
		return session.delete("qnaMapper.deleteReply", reply);
	}

	// 전체 게시글 목록 갯수 가져오기
	public int selectListCount() {
		
		return session.selectOne("qnaMapper.selectListCount");
	}

	//댓글 레벨 증가시키기
	public int updateReplySeq(Qna reply) {
		
		return session.update("qnaMapper.updateReplySeq", reply);
	}

	

	

	

}
