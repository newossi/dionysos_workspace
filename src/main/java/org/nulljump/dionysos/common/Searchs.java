package org.nulljump.dionysos.common;

public class Searchs implements java.io.Serializable {
	private static final long serialVersionUID = 1182062387377766923L;
	private String searchType;
	private String keyword;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Searchs [searchType=" + searchType + ", keyword=" + keyword + "]";
	}

}
