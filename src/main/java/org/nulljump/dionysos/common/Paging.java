package org.nulljump.dionysos.common;

public class Paging {
	// 한 페이지에 출력할 시작행과 끝행을 저장하는 객체
	private int startRow;
	private int endRow;
	private int listCount; // 총 목록 수
	private int limit; // 한 페이지에 출력할 목록수
	private int currentPage; // 출력할 페이지
	private int maxPage; // 총 페이지 수
	private int startPage; //페이지그룹의 시작값
	private int endPage;  //페이지그룹의 끝값

	//생성자 없음
	
	public Paging(int listCount, int currentPage, int limit) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.limit = limit;
	}

	public void calculator() {
		// 페이지 수 계산
		// 주의 : 목록이 11개이면 페이지 수는 2페이지가 됨
		// 나머지 목록 1개도 한 페이지가 필요함
		maxPage = (int) ((double) listCount / limit + 0.95);
		// 현재 페이지가 포함된 페이지 그룹의 시작값과 끝값 계산
		// => 뷰 페이지 아래쪽에 표시할 페이지 숫자를 10개 한다면
		// 현재 페이지가 95라면 91과 100 을 계산해 냄
		startPage = ((currentPage - 1) / 10) * 10 + 1;
		endPage = startPage + 10 - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 쿼리문에 전달할 현재 페이지에 출력할 목록의 시작행과
		// 끝행을 계산
		startRow = (currentPage - 1) * limit + 1;
		endRow = startRow + limit - 1;		
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "Paging [startRow=" + startRow + ", endRow=" + endRow + ", listCount=" + listCount + ", limit=" + limit
				+ ", currentPage=" + currentPage + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	

}
