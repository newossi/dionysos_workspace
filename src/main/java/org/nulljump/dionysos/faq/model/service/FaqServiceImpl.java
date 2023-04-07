package org.nulljump.dionysos.faq.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.faq.model.dao.FaqDao;
import org.nulljump.dionysos.faq.model.vo.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("faqService")
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqDao faqdao;

	// 사용자
	//전체 목록 보기
	@Override
	public ArrayList<Faq> selectFaq() {
		
		return faqdao.selectFaq();
	}


	
	//관리자
	//전체 목록 보기
	@Override
	public Faq selectList(int faq_no) {
		
		return faqdao.selectList(faq_no);
	}

	//자주하는 질문 등록
	@Override
	public int insertFaq(Faq faq) {
		return 0;
	}

	//자주하는 질문 삭제
	@Override
	public int deleteFaq(int faq_no) {
		return 0;
	}

	//자주하는 질문 수정
	@Override
	public int updateFaq(Faq faq) {
		return 0;
	}





}
