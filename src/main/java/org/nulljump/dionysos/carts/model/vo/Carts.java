package org.nulljump.dionysos.carts.model.vo;

import java.io.Serializable;

public class Carts implements Serializable {

	private static final long serialVersionUID = -3996534574803193552L;
	
	private int cart_id; //장바구니 번호
    private String user_id; // 장바구니 소유자 아이디
    private int product_id; // 상품번호
    private int cart_quantity; // 장바구니에 담긴 수량
	
	public Carts() {
		super();
	}

	public Carts(int cart_id, String user_id, int product_id, int cart_quantity) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.cart_quantity = cart_quantity;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Carts [cart_id=" + cart_id + ", user_id=" + user_id + ", product_id=" + product_id + ", cart_quantity="
				+ cart_quantity + "]";
	}
	
}
