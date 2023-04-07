package org.nulljump.dionysos.faq.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.faq.model.vo.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("faqDao")
public class FaqDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	//사용자
	//전체 목록 보기
	public ArrayList<Faq> selectFaq(){
		List<Faq> list = session.selectList("faqMapper.selectFaq");
		
		return (ArrayList<Faq>)list;
	}
	
	
	//관리자
	//상세보기 
	public Faq selectList(int faq_no) {

		return session.selectOne("faqMapper.selectList", faq_no);
	}

	
	//자주하는 질문 등록
	public int insertFaq(Faq faq) {

		return session.insert("faqMapper.insertFaq", faq);
	}
	
	
	//자주하는 질문 삭제
	public int deleteFaq(int faq_no) {

		return session.delete("faqMapper.deleteFaq", faq_no);
	}
	
	
	//자주하는 질문 수정
	public int updateFaq(Faq faq) {

		return session.update("faqMapper.updateFaq", faq);
	}
	
	
	
}
