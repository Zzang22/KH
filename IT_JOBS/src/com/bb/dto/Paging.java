package com.bb.dto;

public class Paging {

	private int totalCount;       //전체 게시글 수 
	private int curPage;          // 현재 페이지 번호
	private int totalPage;        // 전체 페이지 번호
	private int startPage;        // 시작 페이지
	private int endPage;          // 끝 페이지 
	
	public Paging() {

	}

	public Paging(int totalCount, int curPage, int totalPage, int startPage, int endPage) {

		this.totalCount = totalCount;
		this.curPage = curPage;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	public Paging(int totalCount, int curPage) {
		this.totalCount = totalCount;         // totalCount 총 게시물 수. select count(*) as totalCount from board / biz에서 가져와야함
		this.curPage = curPage;
		
		int countList = 6; // 한 페이지당 보일 게시물 수 
		int countPage = 6; // 한 화면에 출력될 페이지 수   <<[1][2][3][4][5]>>
		
		totalPage = totalCount / countList;     // 게시글에 따른 페이지 수
		if(totalCount % countList >0 ) {        // 전체 게시글 갯수 % 한 페이지당 보일 게시물 수 >0 예) 52개면 52 % 5 = 2 
			totalPage++;
		//	System.out.println("totalPage(dto):"+totalPage);
		//	System.out.println("countList(dto):"+countList);
		}
		if(totalPage < curPage) {  //현재 페이지가 총 페이지 번호보다 크다면 현재 페이지를 강제로 총 페이지 번호로 치환
			curPage = totalPage;
		}
		
		//시작페이지, 마지막 페이지
		startPage = ((curPage -1) / countPage) * countPage + 1;
		endPage = startPage + countPage - 1; 
		
		// 마지막 페이지 보정
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	
	
}
