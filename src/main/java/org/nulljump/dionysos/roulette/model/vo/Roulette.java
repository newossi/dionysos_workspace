package org.nulljump.dionysos.roulette.model.vo;

public class Roulette {
	private int resistration_id;
	private int product_id;
	private String food_name;
	private String  food_image;
	private String  product_name;
	private String  product_image;
	private String  sweetness;
	private int body;
	private int tanin;
	private int roulette_no;
	
	public Roulette() {
		super();
	}
	
	public Roulette(int resistration_id, int product_id, String food_name, String food_image, String product_name,
			String product_image, String sweetness, int body, int tanin, int roulette_no) {
		super();
		this.resistration_id = resistration_id;
		this.product_id = product_id;
		this.food_name = food_name;
		this.food_image = food_image;
		this.product_name = product_name;
		this.product_image = product_image;
		this.sweetness = sweetness;
		this.body = body;
		this.tanin = tanin;
		this.roulette_no = roulette_no;
	}

	public int getResistration_id() {
		return resistration_id;
	}

	public void setResistration_id(int resistration_id) {
		this.resistration_id = resistration_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_image() {
		return food_image;
	}

	public void setFood_image(String food_image) {
		this.food_image = food_image;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getSweetness() {
		return sweetness;
	}

	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getTanin() {
		return tanin;
	}

	public void setTanin(int tanin) {
		this.tanin = tanin;
	}

	public int getRoulette_no() {
		return roulette_no;
	}

	public void setRoulette_no(int roulette_no) {
		this.roulette_no = roulette_no;
	}

	@Override
	public String toString() {
		return "Roulette [resistration_id=" + resistration_id + ", product_id=" + product_id + ", food_name="
				+ food_name + ", food_image=" + food_image + ", product_name=" + product_name + ", product_image="
				+ product_image + ", sweetness=" + sweetness + ", body=" + body + ", tanin=" + tanin + ", roulette_no="
				+ roulette_no + "]";
	}

}
