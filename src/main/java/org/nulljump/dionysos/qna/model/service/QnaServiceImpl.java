package org.nulljump.dionysos.qna.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.qna.model.dao.QnaDao;
import org.nulljump.dionysos.qna.model.vo.Qna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao qnaDao;

	@Override
	public ArrayList<Qna> selectAllList() {
		
		return qnaDao.selectAllList();
	}

	@Override
	public ArrayList<Qna> selectList(Paging page) {

		return qnaDao.selectList(page);
	}

	@Override
	public Qna selectQna(int qna_no) {

		return qnaDao.selectQna(qna_no);
	}

	@Override
	public ArrayList<Qna> selectTitleSearch(String title) {

		return qnaDao.selectTitleSearch(title);
	}

	@Override
	public ArrayList<Qna> selectIdSearch(String user_id) {

		return qnaDao.selectIdSearch(user_id);
	}

	@Override
	public ArrayList<Qna> selectDateSearch(SearchDate date) {

		return qnaDao.selectDateSearch(date);
	}

	@Override
	public int insertInquiry(Qna qna) {

		return qnaDao.insertInquiry(qna);
	}

	@Override
	public int updateInquiry(Qna qna) {

		return qnaDao.updateInquiry(qna);
	}

	@Override
	public int deleteInquiry(Qna qna) {

		return qnaDao.deleteInquiry(qna);
	}

	@Override
	public int insertReply(Qna reply) {

		return qnaDao.insertReply(reply);
	}

	@Override
	public int updateReply(Qna reply) {

		return qnaDao.updateReply(reply);
	}

	@Override
	public int deleteReply(Qna reply) {
		
		return qnaDao.deleteReply(reply);
	}

	@Override
	public int selectListCount() {
		
		return qnaDao.selectListCount();
	}

	@Override
	public int updateReplySeq(Qna reply) {

		return qnaDao.updateReplySeq(reply);

	}


	
}
