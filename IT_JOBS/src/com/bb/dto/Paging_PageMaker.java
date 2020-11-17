package com.bb.dto;

public class Paging_PageMaker {
	
	private Paging_Criteria cri;
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	//[이전]으로 이동하는 버튼이 생길 조건이 되는지
	private boolean next;
	//[다음]으로 이동하는 버튼이 생길 조건이 되는지
	
	private int displayPageNum = 10;
	private int tempEndPage;
	
	private void calcData() {
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
		//(무조건올림)(현재페이지/페이지당 보여줄 게시글 수)*페이지당 보여줄 게시글 수
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		//endPage가 현재페이지 기준의 마지막 페이지기 때문에 전체 게시글에 대한 마지막 페이지를 알고 있어야
		//boolean next에 대한 처리를 할 수 있음.
		this.tempEndPage = tempEndPage;
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1? false : true; //1페이지면 이전 누를 수 없게 false
		next = endPage * cri.getPerPageNum() >= totalCount? false : true;
	}
	
	
	
	public Paging_Criteria getCri() {
		return cri;
	}

	public void setCri(Paging_Criteria cri) {
		this.cri = cri;
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTempEndPage() {
		return tempEndPage;
	}

	public void setTempEndPage(int tempEndPage) {
		this.tempEndPage = tempEndPage;
	}

	public void setTotalCount(int totlaCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	public int getTotalCount() {
		return totalCount;
	}


}





















