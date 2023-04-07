package org.nulljump.dionysos.faq.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nulljump.dionysos.faq.model.service.FaqService;
import org.nulljump.dionysos.faq.model.vo.Faq;
import org.nulljump.dionysos.notice.model.vo.Notice;
import org.nulljump.dionysos.qna.model.vo.Qna;
import org.nulljump.dionysos.users.model.vo.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FaqController {
	private static final Logger logger = LoggerFactory.getLogger(FaqController.class);

	@Autowired
	private FaqService faqservice;

	// 자주하는질문 전체 목록 출력
	@RequestMapping("flist.do")
	public String faqListMethod(Model model) {
		ArrayList<Faq> list = faqservice.selectFaq();

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "faq/faqListView";
		} else {
			model.addAttribute("message", "등록된 정보가 없습니다.");
			return "common/error";
		}
	}
	
	
	// 자주하는질문 상세보기 
	@RequestMapping("fdetail.do")
	public String faqDetailMethod(@RequestParam("faqno") int faq_no, Model model, HttpSession session) {
		// 관리자용 상세보기 페이지와 일반회원 또는 비회원 상세보기 페이지 구분
		// HttpSession 을 매개변수에 추가

		Faq faq = faqservice.selectList(faq_no);

		if (faq != null) {
			model.addAttribute("faq", faq);

			Users loginUsers = (Users) session.getAttribute("loginUsers");
			if (loginUsers != null && loginUsers.getAdmin().equals("Y")) {
				// 로그인한 관리자가 요청했다면
				return "faq/faqAdminDetailView";
			} else {
				// 관리자가 아닌 또는 로그인하지 않은 상태에서의 요청이라면
				return "faq/faqDetailView";
			}
		} else {
			model.addAttribute("message", faq_no + "번 상세보기 조회 실패");
			return "common/error";
		}
	}
	
	//자주하는 질문 등록 페이지로 이동 
	@RequestMapping("fwform.do")
	public String moveFaqWriteForm() {
		return "faq/faqWriteForm";
	}
	
	//자주하는 질문 등록
	@RequestMapping(value = "finsert.do", method = RequestMethod.POST)
	public String faqInsertMethod(Faq faq, Model model, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
		
		if (faqservice.insertFaq(faq) > 0) {
			// 공지글 등록 성공시 목록 보기 페이지로 이동
			return "redirect:flist.do";
		} else {
			model.addAttribute("message", "새 공지 등록 실패");
			return "common/error";
		}
	}
	
	
	//자주하는 질문 삭제
	@RequestMapping("fdel.do")
	public String faqDeleteMethod(int faq_no, HttpServletRequest request, Model model) {

		if (faqservice.deleteFaq(faq_no) > 0) {
			return "redirect:flist.do?page=1";

		} else {
			model.addAttribute("message", faq_no + "번 글 삭제 실패");
			return "common/error";
		}
	}
	
	//자주하는 질문 수정
	@RequestMapping(value = "fupdate.do", method = RequestMethod.POST)
	public String faqUpdateMethod(Faq faq, @RequestParam("page") int page, Model model) {

		if (faqservice.updateFaq(faq) > 0) {
			// 댓글, 대댓글 수정 성공시 다시 상세보기 페이지가 보여지게 한다면
			model.addAttribute("faqno", faq.getFaq_no());
			model.addAttribute("page", page);

			return "redirect:fdetail.do";
		} else {
			model.addAttribute("message", faq.getFaq_no() + "번 글 수정실패");

			return "common/error";
		}
	}
	
	// 자주하는 질문 수정페이지로 이동 
	@RequestMapping("fupview.do")
	public String moveUpdatePage(@RequestParam("faqno") int faq_no, Model model) {
		// 수정페이지에 출력할 해당 공지글 다시 조회
		Faq faq = faqservice.selectList(faq_no);

		if (faq != null) {
			model.addAttribute("faq", faq);
			return "faq/faqUpdateForm";
		} else {
			model.addAttribute("message", faq_no + "번 공지글 수정페이지로 이동 실패");
			return "common/error";
		}
	}

	// 사용자
//	public String moveQnAPage() {}
//	
//	public String moveNoticePage() {}


}
