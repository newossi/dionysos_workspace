package org.nulljump.dionysos.notice.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.notice.model.dao.NoticeDao;
import org.nulljump.dionysos.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public ArrayList<Notice> selectAllList() {
		
		return noticeDao.selectAllList();
	}

	@Override
	public ArrayList<Notice> selectList(Paging page) {

		return noticeDao.selectList(page);
	}

	@Override
	public Notice selectNotice(int notice_no) {

		return noticeDao.selectNotice(notice_no);
	}

	@Override
	public ArrayList<Notice> selectSearchTitle(String title) {

		return noticeDao.selectSearchTitle(title);
	}

	@Override
	public ArrayList<Notice> selectSearchDate(SearchDate date) {

		return noticeDao.selectSearchDate(date);
	}

	@Override
	public int addReadCount(int notice_no) {

		return noticeDao.addReadCount(notice_no);
	}

	@Override
	public int insertNotice(Notice notice) {

		return noticeDao.insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {

		return noticeDao.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int notice_no) {
		
		return noticeDao.deleteNotice(notice_no);
	}

	@Override
	public int getListCount() {
		
		return noticeDao.getListCount();
	}

	

}
