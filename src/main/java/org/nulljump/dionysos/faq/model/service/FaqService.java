package org.nulljump.dionysos.faq.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.faq.model.vo.Faq;

public interface FaqService {
	
	ArrayList<Faq> selectFaq();
	Faq selectList(int faq_no);

	int insertFaq(Faq faq);
	int deleteFaq(int faq_no);
	int updateFaq(Faq faq);

}
