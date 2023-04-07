package org.nulljump.dionysos.carts.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.carts.model.vo.Carts;


public interface CartsService {
    int insertCarts(Carts carts);				    //장바구니 추가
    ArrayList<Carts> listCarts(String user_id);     //장바구니 목록
    int deleteCarts(int cart_id);				    //장바구니 개별 삭제
    int deleteAllCarts(String user_id); 		    //장바구니 비우기
    int updateCarts(Carts carts); 				    //장바구니 수량 수정
    int totalPrice(String user_id); 				    //장바구니 금액 합계
  //int countCarts(String user_id, int product_id); //장바구니 상품 갯수
}