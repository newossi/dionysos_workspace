package org.nulljump.dionysos.product.controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nulljump.dionysos.common.FileNameChange;
import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.product.model.service.ProductService;
import org.nulljump.dionysos.product.model.vo.Product;
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

@Controller   //xml에 클래스를 controller로 자동 등록해 줌
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//상품 목록의 총 갯수 보여줌
	@RequestMapping("pcount.do")
	public int getProductListCountMethod(@RequestParam(required = false) Integer product_id) {
	    int count;
	    if (product_id != null) {
	        count = productService.selectListCount();
	    } else {
	        count = productService.selectListCount(); // get count of all products
	    }
	    return count;
	}
	
//	@RequestMapping("plist.do")
//	public String moveProductlistView() {
//		return "product/productListView";
//	}
	
//	//상품 목록 페이지 보여줌
//	@GetMapping
//	public ArrayList<Product> selectPrductsList() {
//		return productService.selectProductList();
//	}
	
	//목록 페이지 단위로 목록보기 요청 처리용 메소드
	@RequestMapping("plistView.do")
	 public ModelAndView productListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
		// 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		// 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
		int listCount = productService.selectListCount();
		Paging paging = new Paging(listCount, currentPage, limit);
		paging.calculator();

		ArrayList<Product> list = productService.selectProductList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);

			mv.setViewName("product/productListView");
		} else {
			mv.addObject("message", currentPage + " 페이지 목록 조회 실패!");
			mv.setViewName("common/error");
		}

		return mv;
	}
//	public ModelAndView productListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {
//		
//		int currentPage = 1;
//		if(page != null) {
//			currentPage = Integer.parseInt(page);
//		}
//		//한 페이지에 상품 10개씩 출력되게 함
//		int limit = 10;
//		int listCount = productService.getListCount();
//		int maxPage = (int)((double)listCount / limit + 0.9);
//		int startPage = ((currentPage - 1) / 10) * 10 + 1;
//		int endPage = startPage + 10 - 1;
//		
//		if(maxPage < endPage) {
//			endPage = maxPage;
//		}
//		
//		//쿼리문에 전달할 현재 페이지에 출력할 목록의 시작행과 끝행을 계산
//		int startRow = (currentPage - 1) * limit + 1;
//		int endRow = startRow + limit - 1;
//		Paging paging = new Paging(startRow, endRow);
//		
//		ArrayList<Product> list = productService.selectProductList(paging);
//		
//		if(list != null && list.size() > 0) {
//			mv.addObject("list", list);
//			mv.addObject("listCount", listCount);
//			mv.addObject("maxPage", maxPage);
//			mv.addObject("currentPage", currentPage);
//			mv.addObject("startPage", startPage);
//			mv.addObject("endPage", endPage);
//			mv.addObject("limit", limit);
//			
//			mv.setViewName("product/productListView");
//		}else {
//			mv.addObject("message", currentPage + "페이지 목록 조회 실패!");
//			mv.setViewName("common/error");
//		}
//		return mv;
//	}
	
	// 상품 리스트 페이지 요청 처리
//	@RequestMapping(value = "plistView.do", method = RequestMethod.GET)
//	public String productListMethod(Model model, HttpServletRequest request, HttpServletResponse response) {
//		ArrayList<Product> selectProductList = productService.selectProductList(Paging page);
//		model.addAttribute("selectProductList", selectProductList);
//		return "product/productListView";
//	}
	
//	//상품 리스트 필터
//	@RequestMapping(value="pfilterList.do", method = RequestMethod.POST)
//	public String productFilterListMethod() {
//		ArrayList<Product> selectFilterProductList = productService.selectFilterProductList();
//		return "product/productListView";
//	}
	
	//최근 본 상품 3개
	@RequestMapping(value="platest3.do", method=RequestMethod.POST)
	public String productLatest3Method() {
		return null;
	}
	
	
//	//신상품 상품 3개
//	@RequestMapping(value="pnew3.do", method=RequestMethod.POST)
//	@ResponseBody
//	public String productNew3Method() throws UnsupportedEncodingException {
//		ArrayList<Product> list = productService.selectNew3();
//		logger.info("pnew3.do : " + list.size());
//		
//		JSONObject sendJson = new JSONObject();
//		JSONArray jarr = new JSONArray();
//		
//		for(Product product : list) {
//			JSONObject job = new JSONObject();
//			
//			job.put("product_name", URLEncoder.encode(product.getProduct_name(), "utf-8"));
//			job.put("product_ename", product.getProduct_ename());
//			job.put("product_price",  product.getProduct_price());
//			job.put("product_image",  product.getProduct_image());
//			
//			jarr.add(job);
//		}
//		sendJson.put("list", jarr);
//		
//		return sendJson.toJSONString();
//		
//	}
//	
//	@RequestMapping(value = "ptop5.do", method = RequestMethod.POST)
//	@ResponseBody
//	public String productTop5Method() throws UnsupportedEncodingException {
//		// ajax로 요청시 리턴 방법은 여러가지가 있음
//		// response 객체 이용시
//		// 1. 출력스트림으로 응답하는 방법 (예: 아이디 중복체크)
//		// 2. 뷰리졸버로 리턴하는 방법 : response body에 값을 저장
//
//		// 조회수 많은 인기 게시글 5개 조회해 옴
//		ArrayList<Product> list = productService.selectTop5();
//		logger.info("ptop5.do : " + list.size()); // 5개 출력 확인
//
//		// 전송용 json 객체 준비
//		JSONObject sendJson = new JSONObject();
//		// 리스트 저장할 json 배열 객체 준비
//		JSONArray jarr = new JSONArray();
//
//		// list를 jarr에 옮기기 (복사)
//		for (Product product : list) {
//			// notice 의 각 필드값 저장할 json 객체 생성
//			JSONObject job = new JSONObject();
//
//			job.put("product_image", product.getProduct_image());
//			// 한글에 대해서는 인코딩해서 json에 담도록 함 (한글깨짐 방지)
//			job.put("product_name", URLEncoder.encode(product.getProduct_name(), "utf-8"));
//			// 날짜는 반드시 toString() 으로 문자열로 바꿔서 json에 담아야 함
//			job.put("product_price", product.getProduct_price());
//
//			jarr.add(job); // job를 jarr에 추가함
//		}
//
//		// 전송용 객체에 jarr 을 담음
//		sendJson.put("list", jarr);
//
//		// json을 json string 타입으로 바꿔서 전송되게 함
//		return sendJson.toJSONString(); // 뷰리졸버로 리턴
//		// servlet-context.xml 에 json string 내보내는 JsonView 라는 뷰리졸버를 추가 등록해야 함
//
//	}
	
	//상품 상세보기 페이지 내보내기용
	@RequestMapping("pdetail.do")
	public String moveProductDetailView() {
		return "product/productDetailView";
	}
	
//	// 상품 상세보기 페이지 요청 처리
//	@RequestMapping("pdetailView.do")
//	public ModelAndView productDetailMethod(ModelAndView mv, @RequestParam("product_id") int product_id,
//			@RequestParam(name = "page", required = false) String page) {
//		int currentPage = 1;
//		if (page != null) {
//			currentPage = Integer.parseInt(page);
//		}
//
////		// 조회수 1 증가 처리
////		boardService.updateBoardReadcount(board_num);
//
//		// 해당 게시글 조회
//		Product product = productService.selectProduct(product_id);
//
//		if (product != null) {
//			mv.addObject("product", product);
//			mv.addObject("currentPage", currentPage);
//
//			mv.setViewName("product/productDetailView");
//		} else {
//			mv.addObject("message", product_id + "번 게시글 조회 실패!");
//			mv.setViewName("common/error");
//		}
//
//		return mv;
//	}
//	public String productDetailMethod(
//			@RequestParam("product_id") int product_id, Model model, HttpSession session) {
//		Product product = productService.selectProduct(product_id);
//		if(product != null) {
//			model.addAttribute("product", product);
//			
//			return "product/productDetailView";
//		}else {
//			model.addAttribute("message", product + " 상품이 품절 혹은 존재하지 않습니다.");
//			return "common/error";
//		}
//	}

//	//결제 페이지 내보내기용
//	@RequestMapping(value="paymentPage.do", method= {RequestMethod.GET, RequestMethod.POST})
//	public String movePaymentPage() {
//		return "payment/paymentPage";
//	}
//	
//	//장바구니 페이지 내보내기용
//	@RequestMapping(value="cartsPage.do", method= {RequestMethod.GET, RequestMethod.POST})
//	public String moveCartsPage() {
//		return "carts/cartsPage";
//	}
	
	//상품 검색 조회
	@RequestMapping(value="psearch.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String productSearchMethod(HttpServletRequest request, Model model) {
		String action = request.getParameter("action");
		String keyword = null;
		
		ArrayList<Product> list = null;
		
		switch(action) {
		
//		case "id": list = productService.selectSearchProductId(Integer.parseInt(keyword));
//					break;
		case "name": list = productService.selectSearchProductName(keyword);
					break;
		case "ename": list = productService.selectSearchProductEname(keyword);
					break;
		case "price": list = productService.selectSearchProductPrice(Integer.parseInt(keyword));
					break;
		case "acidity": list = productService.selectSearchProductAcidity(Integer.parseInt(keyword));
					break;
		case "alcohol": list = productService.selectSearchProductAlcohol(Float.parseFloat(keyword));
					break;
		case "sweetness": list = productService.selectSearchProductSweetness(Integer.parseInt(keyword));
					break;
		case "body": list = productService.selectSearchProductBody(Integer.parseInt(keyword));
					break;
		case "tannin": list = productService.selectSearchProductTannin(Integer.parseInt(keyword));
					break;
		case "origin": list = productService.selectSearchProductOrigin(keyword);
					break;
		case "wine_type": list = productService.selectSearchProductType(keyword);
					break;
		}  //switch
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "product/productListView";
		}else {
			model.addAttribute("message", action + " 상품이 품절 혹은 존재하지 않습니다.");
			return "common/error";
		}
	}
	
	//관리자 기능
	
	//관리자 확인용 메소드
	
	// 상품 등록 페이지 요청
	@RequestMapping(value="pinsertForm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveProductInsert() {
		return "product/productInsertForm";
	}

	// 상품 등록 처리
	@RequestMapping(value = "pinsert.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String productInsertMethod(Product product, Model model, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
		
		//상품 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/product_upfiles");
		
		//첨부파일
		String fileName = mfile.getOriginalFilename();
		
		if(fileName != null && fileName.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			//변경할 파일명 만들기
		    String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));
			
		    renameFileName += "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		    logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);
		    
		    File renameFile = new File(savePath +"\\" + renameFileName);
		    
		    try {
		    	mfile.transferTo(renameFile);
		    }catch(Exception e){
		    	e.printStackTrace();
		    	model.addAttribute("message", "첨부파일 저장 실패!");
		    	return "common/error";
		    }
		}
		if(productService.insertProduct(product) > 0) {
			//상품 등록 성공시 목록 보기 페이지로 이동
			return "redirect:plistView.do";
		}else {
			model.addAttribute("message", product.getProduct_id() + "새 상품 등록 실패!");
			return "common/error";
		}
	}
	
	// 상품 수정 페이지 요청
	@RequestMapping(value="pupdateForm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveProductUpdateView(@RequestParam("product_id") int product_id, @RequestParam("page") int currentPage, Model model) {
		//수정페이지로 보낼 product 객체 정보 조회함
		Product product = productService.selectProduct(product_id);
		
		if(product != null) {
			model.addAttribute("product", product);
			model.addAttribute("currentPage", currentPage);
			
			return "product/productUpdateForm";
		}else {
			model.addAttribute("message", product_id +"상품 수정페이지로 이동 실패!");
			
			return "common/error";
		}
	}

	// 상품 수정 처리
	@RequestMapping(value = "pupdate.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String productUpdateMethod(Product product, Model model, HttpServletRequest request,
			@RequestParam(name = "delflag", required = false) String delFlag,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile,
			@RequestParam("page") int page) {
		
		//상품 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/product_upfiles");
		
		//첨부파일이 수정 처리된 경우 ------------------------------------------
		if(product.getProduct_image() != null && delFlag != null && delFlag.equals("yes")) {
			//저장 폴더에 있는 파일을 삭제함
			new File(savePath + "/" + product.getProduct_image()).delete();
		}
		//2.상품 첨부파일 1개만 가능한 경우
		//새로운 첨부파일 있을 때
		if(!mfile.isEmpty()) {
			//2-1. 이전 첨부파일이 있을 때
			if(product.getProduct_image() != null) {
				//저장 폴더에 있는 이전 파일 삭제함
				new File(savePath + "/" + product.getProduct_image()).delete();
			}
			//2-2. 이전 첨부파일이 없을 때
			//전송 온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			
			if(fileName != null && fileName.length() > 0) {
				String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
				
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
			}
		}

		if(productService.updateProduct(product) > 0) {
			//상품 수정 성공시 상세보기 페이지로 이동
			model.addAttribute("page", page);
			model.addAttribute("product_id", product.getProduct_id());
			
			return "redirect:pdetailView.do";
		} else {
			model.addAttribute("message", product.getProduct_id() + "상품 수정 실패!");
			return "common/error";
		}
	}


	// 상품 삭제 처리
	@RequestMapping(value = "pdelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String productDeleteMethod(Product product, HttpServletRequest request, Model model) {
    	if(productService.deleteProduct(product) > 0) {
    		//글 삭제가 성공하면, 저장폴더에 있는 첨부파일도 삭제 처리
    			new File(request.getSession().getServletContext().getRealPath("resources/product_upfiles") + "/" + product.getProduct_image()).delete();
    			return "redirect:plistView.do?page=1";	
    	}else {
    		model.addAttribute("message", product.getProduct_id() + "상품 삭제 실패!");
    		return "common/error";
    	}
    }
	
	 @RequestMapping(value="advsearch.do", method=RequestMethod.POST) 
	 public String advancedSearchMethod(@RequestParam("wine_type") List<String> wine_type, 
			 						     @RequestParam("wine_origin") List<String> wine_origin,
			 						    @RequestParam("product_price") List<String> product_price,
			 						   @RequestParam("sweetness") int sweetness,
			 						  @RequestParam("acidity") int acidity,
			 						 @RequestParam("body") int body,
			 						@RequestParam("tannin") int tannin, Model model) {
		 
		 return "redirect:product/productList";
	 }
	 
//		@RequestMapping("psearchType.do")
//		public String searchWineTypeMethod(@RequestParam("wine_type") String wine_type, Model model) {
//			ArrayList<Product> list = productService.selectSearchWineType(wine_type);
//			 logger.info("list : " + list.size());
//			 if(list != null && list.size() > 0) {
//				 model.addAttribute("list", list);
//				 
//				 return "product/productListView";
//			 } else {
//				 model.addAttribute("message", "검색결과가 존재하지 않습니다.");
//				 return "common/error";
//			 }
//			
//		}
	 
//	 @RequestMapping("psearchName.do")
//	 public String productNameSearchMethod(String product_name, Model model) {
//		 ArrayList<Product> list = productService.selectSearchProductName(product_name);
//		 logger.info("list : " + list);
//		 if(list != null && list.size() > 0) {
//			 model.addAttribute("list", list);
//			 
//			 return "product/productListView";
//		 } else {
//			 model.addAttribute("message", "검색결과가 존재하지 않습니다.");
//			 return "common/error";
//		 }
//		
//		 
//		 
//	 }
	
		

	
	
		
		
		
}
