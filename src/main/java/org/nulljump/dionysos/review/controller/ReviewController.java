package org.nulljump.dionysos.review.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.nulljump.dionysos.common.FileNameChange;
import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.review.model.service.ReviewService;
import org.nulljump.dionysos.review.model.vo.Review;
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
 
@Controller    //xml에 클래스를 controller로 자동 등록해 줌
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	
	public ReviewController(ReviewService reviewService) {
	    this.reviewService = reviewService;
	  }

    // 리뷰 목록 보기
    @RequestMapping("rlistView.do")
    public ModelAndView reviewListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
		// 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		// 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
		int listCount = reviewService.getListCount();
		Paging paging = new Paging(listCount, currentPage, limit);
		paging.calculator();

		ArrayList<Review> list = reviewService.selectReviewList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);

			mv.setViewName("review/reviewListView");
		} else {
			mv.addObject("message", currentPage + " 페이지 목록 조회 실패!");
			mv.setViewName("common/error");
		}

		return mv;
	}
//    public ModelAndView reviewListMethod(@RequestParam(name ="page", required = false) String page, ModelAndView mv) {
//      
//    	int currentPage = 1;
//    	if(page != null) {
//    		currentPage = Integer.parseInt(page);
//    	}
//    	//한 페이지에 리뷰 게시글 10개씩 출력되게 하는 경우
//    	//페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
//    	int limit = 10;  //한 페이지에 출력할 목록 갯수
//    	//총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
//    	int listCount = reviewService.getListCount();
//    	//페이지 수 계산
//    	int maxPage = (int)((double) listCount / limit + 0.9);
//    	
//    	int startPage = ((currentPage - 1) / 10) * 10 + 1;
//    	int endPage = startPage + 10 - 1;
//    	
//    	if(maxPage < endPage) {
//    		endPage = maxPage;
//    	}
//    	
//    	//쿼리문에 전달할 현재 페이지에 풀력할 목록의 시작행과 끝행을 계산
//    	int startRow = (currentPage - 1) * limit + 1;
//    	int endRow = startRow + limit - 1;
//    	Paging paging = new Paging(startRow, endRow);
//    	
//    	ArrayList<Review> list = reviewService.selectReviewList(paging);
//    	
//    	if(list != null && list.size() > 0) {
//    		mv.addObject("list", list);
//    		mv.addObject("listCount", listCount);
//    		mv.addObject("maxPage", maxPage);
//    		mv.addObject("currentPage", currentPage);
//    		mv.addObject("startPage", startPage);
//    		mv.addObject("endPage", endPage);
//    		mv.addObject("limit", limit);
//    		
//    		mv.setViewName("review/reviewListView");
//    	}else{
//    		mv.addObject("message", currentPage + "페이지 목록 조회 실패!");
//    		mv.setViewName("common/error");
//    	}
//    	
//        return mv;
//    }

    // 리뷰 작성 페이지 이동
    @RequestMapping("rwriteForm.do")
    public String moveReviewWriteForm() {
    	return "review/reviewWriteForm";
    }

    // 리뷰 작성 처리(/*파일 업로드 기능 사용*/)
    @RequestMapping(value = "rwrite.do", method = RequestMethod.POST)
    public String reviewMethod(Review review, Model model, HttpServletRequest request,
    	@RequestParam(name = "upfile", required = false) MultipartFile mfile){
    		
    		//리뷰 첨부파일 저장 폴더 경로 지정 
    		String savePath = request.getSession().getServletContext().getRealPath("resources/review_upfiles");
    		
    		//첨부파일 있을 때
    		if(!mfile.isEmpty()) {
    			
    			String fileName = mfile.getOriginalFilename();
    			
    			if(fileName != null && fileName.length() > 0) {
    				//바꿀 파일명에 대한 문자열 만들기 
    				//공지글 등록 | 수정 요청시점의 날짜시간정보를 이용함
    				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    				//변경할 파일명 만들기
    				String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));
    				
    				//원본 파일의 확장자를 추출해서, 변경 파일명에 붙여줌
    				renameFileName += "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    				logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);
    				
    				//폴더에 저장 처리
    				try {
    					mfile.transferTo(new File(savePath + "\\" + renameFileName));
    				}catch(Exception e){
    					e.printStackTrace();
    					model.addAttribute("message", "첨부파일 저장 실패!");
    					return "common/error";
    				}
    				
//    				//reivew 객체에 첨부파일 정보 기록 저장 
//    				review.setReview_original_filename(fileName);
//    				review.setReview_rename_filename(renameFileName);
    			}  //이름 바꾸기
    		} //새로운 첨부파일이 있을 때
    		
    		if(reviewService.insertReview(review) > 0) {
    			//리뷰 등록 성공시 목록 보기 페이지로 이동
    			return "redirect:rlist.do";
    		}else {
    			model.addAttribute("message", review.getReview_id() + "새 리뷰 등록 실패!");
    			return "common/error";
    		}
    	}

    //리뷰 상세 페이지 이동
    @RequestMapping("rdetailView.do")
    public String moveReviewDetailView() {
    	return "review/reviewDetailView";
    }
    
    // 리뷰 상세 보기 처리용
    @RequestMapping("rdetail.do")
    public ModelAndView reviewDetailMethod(ModelAndView mv, @RequestParam("review_id") int review_id,
    		@RequestParam(name = "page", required = false) String page) {
    	int currentPage = 1;
    	if(page != null) {
    		currentPage = Integer.parseInt(page);
    	}
    	
    	//조회수 1증가 처리
    	reviewService.updateReviewReadcount(review_id);
    	
    	//해당 게시글 조회 
    	Review review = reviewService.selectReview(review_id);
    	
    	if(review != null) {
    		mv.addObject("review", review);
    		mv.addObject("currentPage", currentPage);
    		mv.setViewName("review/reviewDetailView");
    	}else {
    		mv.addObject("message", review_id + "번 게시글 조회 실패!");
    		mv.setViewName("common/error");
    	}
    	return mv;
    }

    // 리뷰 수정 페이지 이동 처리용
    @RequestMapping("rupdateForm.do")
    public String moveReviewUpdateView(@RequestParam("review_id") int review_id, @RequestParam("page") int currentPage, Model model) {
        //수정페이지로 보낼 reivew 객체 정보 조회함
    	Review review = reviewService.selectReview(review_id);
    	
    	if(review != null) {
    		model.addAttribute("review", review);
    		model.addAttribute("currentPage", currentPage);
    		
    		return "review/reviewUpdateForm";
    	}else {
    		model.addAttribute("message", review_id + "번 글 수정페이지로 이동 실패!");
    		
    		return "common/error";
    	}
    }

    // 리뷰 수정 처리 (파일 업로드 기능 사용)
    @RequestMapping(value = "rupdate.do", method = RequestMethod.POST)
    public String reviewUpdateMethod(Review review, Model model, HttpServletRequest request,
    		@RequestParam(name = "delflag", required = false) String delFlag,
    		@RequestParam(name = "upfile", required = false) MultipartFile mfile,
    		@RequestParam("page") int page) {
        //리뷰 첨부파일 저장 폴더 경로 지정
    	String savePath = request.getSession().getServletContext().getRealPath("resources/review_upfiles");
    	//1. 원래 첨부파일이 있는데, '파일삭제'를 선택한 경우
    	if(review.getReview_image() != null && delFlag!= null && delFlag.equals("yes")) {
    		//저장 폴더에 있는 파일을 삭제함 
    		new File(savePath + "/" + review.getReview_image()).delete();

    	}
    	//2. 리뷰 첨부파일 1개만 가능한 경우
    	//새로운 첨부파일이 있을 때 
    	if(!mfile.isEmpty()) {
    		//2-1. 이전 첨부파일이 있을 때
    		if(review.getReview_image() != null) {
    			//저장 폴더 안에 있는 이전 파일을 삭제함
    			new File(savePath + "/" + review.getReview_image()).delete();

    		}
    		//2-2. 이전 첨부파일이 없을 때
    		//전송 온 파일이름 추출함
    		String fileName = mfile.getOriginalFilename();
    		
    		if(fileName != null && fileName.length() > 0) {
    			//바꿀 파일명에 대한 문자열 만들기 
    			//공지글 등록 | 수정 요청시점의 날짜시간정보를 이용함
    			String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
    			
    			//원본 파일의 확장자를 추출해서, 변경 파일명에 붙여줌
    			renameFileName += "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    			logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);
    			
    			//파일 객체 만들기
    			File renameFile = new File(savePath + "/" + renameFileName);
    			
    			//폴더에 저장 처리 
    			try {
    				mfile.transferTo(renameFile);
    			}catch(Exception e) {
    				e.printStackTrace();
    				model.addAttribute("message", "첨부파일 저장 실패!");
    				return "common/error";
    			}
    		} //이름 바꾸기
    	} //새로운 첨부파일이 있을 때
    	
    	if(reviewService.updateReview(review) > 0) {
    		//리뷰 원글 수정시 상세보기 페이지로 이동
    		model.addAttribute("page", page);
    		model.addAttribute("review_id", review.getReview_id());
    		
    		return "redirect:rdetail.do";
    	} else {
    		model.addAttribute("message", review.getReview_id() + "번 리뷰 수정 실패!");
    		return "common/error";
    	}
    }

    // 리뷰 삭제 처리
    @RequestMapping("rdelete.do")
    public String reviewDeleteMethod(Review review, HttpServletRequest request, Model model) {
    	if(reviewService.deleteReview(review) > 0) {
    		//글 삭제가 성공하면, 저장폴더에 있는 첨부파일도 삭제 처리
    			new File(request.getSession().getServletContext().getRealPath("resources/review_upfiles") + "/" + review.getReview_image()).delete();
    			return "redirect:rlist.do?page=1";	
    	}else {
    		model.addAttribute("message", review.getReview_id() + "번 글 삭제 실패!");
    		return "common/error";
    	}
    }
	  
}
