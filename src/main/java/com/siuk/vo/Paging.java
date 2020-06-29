package com.siuk.vo;

public class Paging {
	
	private Integer pageSize = 5;
	private Integer totalPage;
	
	private Integer reqPage = 1;
	private boolean next;
	private boolean prev;
	
	private Integer firstRow;
	
	private String keyword = "";
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setReqPage(Integer reqPage) {
		if(reqPage < 1) {
			this.reqPage = 1;
		} else {
			this.reqPage = reqPage;
		}
	}
	
	public void setTotalRows(Integer totalRows) {
		if(totalRows < 1) {
			totalPage = 0;
			return;
		}
		if(totalRows % pageSize == 0 ) {
			totalPage = totalRows/pageSize;
		} else {
			totalPage = (totalRows / pageSize) + 1;
		}
		
		if(reqPage > 1) {
			prev = true;
		}
		if(reqPage < totalPage) {
			next = true;
		}
		
		firstRow = (reqPage-1)*pageSize;
	}
	
	public Integer getFirstRow() {
		return firstRow;
	}
	
	public Integer getReqPage() {
		return reqPage;
	}

	public boolean isNext() {
		return next;
	}

	public boolean isPrev() {
		return prev;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}

	@Override
	public String toString() {
		return "Paging [pageSize=" + pageSize + ", totalPage=" + totalPage + ", reqPage=" + reqPage + ", next=" + next
				+ ", prev=" + prev + ", firstRow=" + firstRow + ", keyword=" + keyword + "]";
	}

}
