package org.nulljump.dionysos.product.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.product.model.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productDao")  //xml에 자동 등록됨
public class ProductDao {

	@Autowired
	private SqlSessionTemplate session;   //의존성 주입
	
	public ArrayList<Product> selectProductList(Paging page) {
		List<Product> list = session.selectList("productMapper.selectProductList", page);
		return (ArrayList<Product>)list;
	}
	
	public ArrayList<Product> selectTop4() {
		List<Product> list = session.selectList("productMapper.selectTop4");
		return (ArrayList<Product>)list;
	}
	
	public ArrayList<Product> selectNew4() {
		List<Product> list = session.selectList("productMapper.selectNew4");
		return (ArrayList<Product>)list;
	}
	
	//상품 목록의 총 갯수 조회
	public int selectListCount() {
		return session.selectOne("productMapper.selectListCount");
	}

	public Product selectProduct(int product_id) {
		return session.selectOne("productMapper.selectProduct", product_id);
	}

	//특정 범위에 해당하는 상품 목록 조회
	public ArrayList<Product> selectFilterProductList() {
		List<Product> list = session.selectList("productMapper.selectFilterProductList");
		return (ArrayList<Product>) list;
	}

	//검색 처리용
	public ArrayList<Product> selectSearchProductId(int keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductName(String keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProductName", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductEname(String keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProductEname", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductPrice(int keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProductPrice", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductAlcohol(float keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProductAlcohol", keyword);
		return (ArrayList<Product>)list;
	}
	
	public ArrayList<Product> selectSearchProductAcidity(int keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProductAcidity", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductSweetness(int keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductBody(int keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductTannin(int keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductOrigin(String keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", keyword);
		return (ArrayList<Product>)list;
	}

	public ArrayList<Product> selectSearchProductType(String keyword) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", keyword);
		return (ArrayList<Product>)list;
	}

	//관리자
	public int insertProduct(Product product) {
		return session.selectOne("productMapper.insertProduct", product);
	}

	public int updateProduct(Product product) {
		return session.selectOne("productMapper.updateProduct", product);
	}

	public int deleteProduct(Product product) {
		return session.selectOne("productMapper.deleteProduct", product);
	}

	public ArrayList<Product> selectSearchWineType(String wine_type) {
		List<Product> list = session.selectList("productMapper.selectSearchProduct", wine_type);
		return (ArrayList<Product>)list;
	}


}
