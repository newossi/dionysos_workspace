package org.nulljump.dionysos.winedictionary.model.vo;

public class WineDictionary implements java.io.Serializable {
	
	private static final long serialVersionUID = -5987902088992523087L;
	
	private String grape_type;
	private int sweetness;
	private int acidity;
	private int body;
	private int tannin;
	private String wine_dictionary;
	
	public WineDictionary() {
		super();
	}

	public WineDictionary(String grape_type, int sweetness, int acidity, int body, int tannin, String wine_dictionary) {
		super();
		this.grape_type = grape_type;
		this.sweetness = sweetness;
		this.acidity = acidity;
		this.body = body;
		this.tannin = tannin;
		this.wine_dictionary = wine_dictionary;
	}

	public String getGrape_type() {
		return grape_type;
	}

	public void setGrape_type(String grape_type) {
		this.grape_type = grape_type;
	}

	public int getSweetness() {
		return sweetness;
	}

	public void setSweetness(int sweetness) {
		this.sweetness = sweetness;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getTannin() {
		return tannin;
	}

	public void setTannin(int tannin) {
		this.tannin = tannin;
	}

	public String getWine_dictionary() {
		return wine_dictionary;
	}

	public void setWine_dictionary(String wine_dictionary) {
		this.wine_dictionary = wine_dictionary;
	}

	public int getAcidity() {
		return acidity;
	}

	public void setAcidity(int acidity) {
		this.acidity = acidity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WineDictionary [grape_type=" + grape_type + ", sweetness=" + sweetness + ", acidity=" + acidity
				+ ", body=" + body + ", tannin=" + tannin + ", wine_dictionary=" + wine_dictionary + "]";
	}

	

}
