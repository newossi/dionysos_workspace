package org.nulljump.dionysos.notice.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nulljump.dionysos.common.FileNameChange;
import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.notice.model.service.NoticeService;
import org.nulljump.dionysos.notice.model.vo.Notice;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeservice;

	// 공지사항 전체 목록 출력
	@RequestMapping("nlist.do")
	public String noticeAllListMethod(Model model) {
		ArrayList<Notice> list = noticeservice.selectAllList();

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "notice/noticeListView";
		} else {
			model.addAttribute("message", "등록된 정보가 없습니다.");
			return "common/error";
		}
	}

	// 공지사항 페이지 단위로 목록보기 요청 처리용 메소드
	@RequestMapping("nplist.do")
	public ModelAndView noticeListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10; // 한 페이지에 출력할 목록 갯수
		// 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
		int listCount = noticeservice.getListCount();
		Paging paging = new Paging(listCount, currentPage, limit);
		paging.calculator();

		ArrayList<Notice> list = noticeservice.selectList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);

			mv.setViewName("notice/noticeListView");
		} else {
			mv.addObject("message", currentPage + " 페이지 목록 조회 실패!");
			mv.setViewName("common/error");
		}

		return mv;
	}

	// 공지사항 상세보기 처리용
	@RequestMapping("ndetail.do")
	public String noticeDetailMethod(@RequestParam("noticeno") int notice_no, Model model, HttpSession session) {
		// 관리자용 상세보기 페이지와 일반회원 또는 비회원 상세보기 페이지 구분
		// HttpSession 을 매개변수에 추가

		Notice notice = noticeservice.selectNotice(notice_no);

		if (notice != null) {
			model.addAttribute("notice", notice);

			Users loginUsers = (Users) session.getAttribute("loginUsers");
			if (loginUsers != null && loginUsers.getAdmin().equals("Y")) {
				// 로그인한 관리자가 요청했다면
				return "notice/noticeAdminDetailView";
			} else {
				// 관리자가 아닌 또는 로그인하지 않은 상태에서의 요청이라면
				return "notice/noticeDetailView";
			}
		} else {
			model.addAttribute("message", notice_no + "번 공지글 상세보기 조회 실패");
			return "common/error";
		}
	}

	// 첨부파일 다운로드 요청 처리용
	@RequestMapping("nfdown.do")
	public ModelAndView fileDownMethod(ModelAndView mv, HttpServletRequest request,
			@RequestParam("ofile") String originalFileName, @RequestParam("rfile") String renameFileName) {
		// 공지사항 첨부파일 저장폴더에 대한 경로(path) 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

		// 저장 폴더에서 읽을 파일에 대한 파일 객체 생성
		File renameFile = new File(savePath + "\\" + renameFileName);
		// 파일 다운시 내보낼 원래 이름의 파일 객체 생성
		File originFile = new File(originalFileName);

		// 파일 다운로드 뷰로 전달할 정보 저장
		mv.setViewName("filedown"); // 등록된 파일다운로드 뷰의 id명
		mv.addObject("renameFile", renameFile);
		mv.addObject("originFile", originFile);

		return mv;
	}

	// 공지글 수정페이지로 이동 요청 처리용
	@RequestMapping("nmoveup.do")
	public String moveUpdatePage(@RequestParam("noticeno") int notice_no, Model model) {
		// 수정페이지에 출력할 해당 공지글 다시 조회
		Notice notice = noticeservice.selectNotice(notice_no);

		if (notice != null) {
			model.addAttribute("notice", notice);
			return "notice/noticeUpdateForm";
		} else {
			model.addAttribute("message", notice_no + "번 공지글 수정페이지로 이동 실패");
			return "common/error";
		}
	}

	// 공지글 제목 검색용
	@RequestMapping(value = "nsearchTitle.do", method = RequestMethod.POST)
	public String noticeSearchTitleMethod(@RequestParam("title") String title, Model model) {

		ArrayList<Notice> list = noticeservice.selectSearchTitle(title);

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "notice/noticeListView";
		} else {
			model.addAttribute("message", title + "로 검색된 공지글 정보가 없습니다.");
			return "common/error";
		}

	}

	// 공지글 등록날짜 검색용
	@RequestMapping(value = "nsearchDate.do", method = RequestMethod.POST)
	public String noticeSearchDateMethod(SearchDate date, Model model) {

		ArrayList<Notice> list = noticeservice.selectSearchDate(date);

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "notice/noticeListView";
		} else {
			model.addAttribute("message", "해당 날짜로 등록된 공지글 정보가 없습니다.");
			return "common/error";
		}
	}
	
	

	// 새 공지글 등록 페이지로 이동 처리용
	@RequestMapping("nwform.do")
	public String moveWritePage() {

		return "notice/noticeWriteForm";
	}

	// 공지글 등록 요청 처리용 (파일 업로드 기능 사용)
	@RequestMapping(value = "ninsert.do", method = RequestMethod.POST)
	public String noticeInsertMethod(Notice notice, Model model, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
		// 공지사항 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

		// 첨부파일이 있을 때
		if (!mfile.isEmpty()) {
			// 전송 온 파일이름 추출
			String fileName = mfile.getOriginalFilename();

			// 다른 공지글의 첨부파일과 파일명이 중복되어 덮어쓰기 되는 것을 막기 위해
			// 파일명을 변경해서 폴더에 저장하는 방식을 사용할 수 있음
			// 변경 파일명 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");

				logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);

				// 파일 객체 만들기
				File renameFile = new File(savePath + "\\" + renameFileName);

				// 폴더에 저장 처리
				try {
					mfile.transferTo(renameFile);
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일 저장 실패");
					return "common/error";
				}

				// notice 객체에 첨부파일 정보 기록 저장
				notice.setNotice_original_filename(fileName);
				notice.setNotice_rename_filename(renameFileName);
			} // 이름 바꾸기
		} // 새로운 첨부파일이 있을 때

		if (noticeservice.insertNotice(notice) > 0) {
			// 공지글 등록 성공시 목록 보기 페이지로 이동
			return "redirect:nlist.do";
		} else {
			model.addAttribute("message", "새 공지 등록 실패");
			return "common/error";
		}
	}

	// 공지글 수정 요청 처리용 (파일 업로드 기능 사용)
	@RequestMapping(value = "nupdate.do", method = RequestMethod.POST)
	public String noticeUpdateMethod(Notice notice, Model model, HttpServletRequest request,
			@RequestParam(name = "delflag", required = false) String delFlag,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
		// 공지사항 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

		// 첨부파일이 수정 처리된 경우 -------------------------
		// 1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
		if (notice.getNotice_original_filename() != null && delFlag != null && delFlag.equals("yes")) {
			// 저장 폴더에 있는 파일을 삭제
			new File(savePath + "\\" + notice.getNotice_rename_filename()).delete();
			// notice 의 파일 정보도 제거
			notice.setNotice_original_filename(null);
			notice.setNotice_rename_filename(null);
		}

		// 2. 공지글 첨부파일은 1개만 가능한 경우
		// 새로운 첨부파일이 있을 때
		if (!mfile.isEmpty()) {
			// 2-1. 이전 첨부파일이 있을 때
			if (notice.getNotice_original_filename() != null) {
				// 저장 폴더에 있는 이전 파일을 삭제
				new File(savePath + "\\" + notice.getNotice_rename_filename()).delete();
				// notice의 이전 파일 정보 제거
				notice.setNotice_original_filename(null);
				notice.setNotice_rename_filename(null);
			}

			// 2-2. 이전 첨부파일이 없을 때
			// 전송 온 파일이름 추출
			String fileName = mfile.getOriginalFilename();

			// 다른 공지글의 첨부파일과 파일명이 중복되어 덮어쓰기 되는 것을 막기 위해
			// 파일명을 변경해서 폴더에 저장하는 방식을 사용할 수 있음
			// 변경 파일명 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				// 공지글 등록 또는 수정 요청 시점의 날짜시간정보를 이용
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				// 변경할 파일명 만들기
				String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));

				// 원본 파일의 확장자를 추출해서 변경 파일명에 붙여줌
				renameFileName += "." + fileName.substring(fileName.lastIndexOf(".") + 1);

				logger.info("변경 파일명 : " + renameFileName);

				// 파일 객체 만들기
				File renameFile = new File(savePath + "\\" + renameFileName);

				// 폴더에 저장 처리
				try {
					mfile.transferTo(renameFile);
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일 저장 실패");
					return "common/error";
				}

				// notice 객체에 첨부파일 정보 기록 저장
				notice.setNotice_original_filename(fileName);
				notice.setNotice_rename_filename(renameFileName);
			} // 이름 바꾸기
		} // 새로운 첨부파일이 있을 때

		if (noticeservice.updateNotice(notice) > 0) {
			// 공지글 수정 성공시 목록 보기 페이지로 이동
			return "redirect:nlist.do";
		} else {
			model.addAttribute("message", notice.getNotice_no() + "번 공지 수정 실패");
			return "common/error";
		}
	}

	// 공지글 삭제 요청 처리용
	@RequestMapping("ndel.do")
	public String noticeDeleteMethod(@RequestParam("noticeno") int notice_no,
			@RequestParam(name = "rfile", required = false) String renameFileName, Model model,
			HttpServletRequest request) {

		if (noticeservice.deleteNotice(notice_no) > 0) {
			// 첨부된 파일이 있는 공지일 때는 저장 폴더에 있는 첨부파일도 삭제
			if (renameFileName != null) {
				// 공지사항 첨부파일 저장폴더에 대한 경로(path) 지정
				String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

				new File(savePath + "\\" + renameFileName).delete();
			}
			return "redirect:nlist.do";
		} else {
			model.addAttribute("message", notice_no + "번 공지 삭제 실패");
			return "common/error";
		}
	}



//	// 사용자
//
//	public String moveListPage() {
//	}
//
//	public String moveFaqPage() {
//	}
//
//	public String moveQnAPage() {
//	}
//


}
