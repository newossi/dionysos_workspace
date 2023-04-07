package org.nulljump.dionysos.product.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.product.model.vo.Product;

public interface ProductService {

	int selectListCount();               				 //상품 목록의 총 갯수 조회   
	ArrayList<Product> selectProductList(Paging page);  //상품 목록 조회  
	ArrayList<Product> selectTop4();				// 가장 많이 팔린 4개 조회
	ArrayList<Product> selectNew4();                 //신상품 4개 조회
	Product selectProduct(int product_id);           //특정 상품 id에 해당하는 상품 조회     
	ArrayList<Product> selectFilterProductList();    //특정 범위에 해당하는 상품 목록 조회
	
	//검색을 위한 메소드
	ArrayList<Product> selectSearchProductId(int keyword);
	ArrayList<Product> selectSearchProductName(String keyword);
	ArrayList<Product> selectSearchProductEname(String keyword);
	ArrayList<Product> selectSearchProductPrice(int keyword);
	ArrayList<Product> selectSearchProductAlcohol(float keyword);
	ArrayList<Product> selectSearchProductAcidity(int keyword);
	ArrayList<Product> selectSearchProductSweetness(int keyword);
	ArrayList<Product> selectSearchProductBody(int keyword);
	ArrayList<Product> selectSearchProductTannin(int keyword);
	ArrayList<Product> selectSearchProductOrigin(String keyword);
	ArrayList<Product> selectSearchProductType(String keyword);
	
	//관리자
	int insertProduct(Product product);           //상품 추가
	int updateProduct(Product product);           //상품 수정
	int deleteProduct(Product product);           //상품 삭제

	ArrayList<Product> selectSearchWineType(String wine_type);

	
}
