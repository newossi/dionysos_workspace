package org.nulljump.dionysos.carts.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.carts.model.vo.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cartsDao")
public class CartsDao {
	@Autowired    //root-context.xml 에서 생성된 객체와 자동 연결
	private SqlSessionTemplate session;    //의존성 주입(DI)

	public int insertCarts(Carts carts) {
		return session.selectOne("cartsMapper.insertCarts", carts);
	}

	public ArrayList<Carts> listCarts(String user_id) {
		List<Carts> list = session.selectList("cartsMapper.listCarts", user_id);
		return (ArrayList<Carts>)list;
	}

	public int deleteCarts(int cart_id) {
		return session.delete("cartsMapper.deleteCarts", cart_id);
	}

	public int deleteAllCarts(String user_id) {
		return session.delete("cartsMapper.deleteAllCarts", user_id);
	}

	public int updateCarts(Carts carts) {
		return session.update("cartsMapper.updateCarts", carts);
	}

	public int totalPrice(String user_id) {
		return session.selectOne("cartsMapper.totalPrice", user_id);
	}

//	public int countCarts(String user_id, int product_id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
}
