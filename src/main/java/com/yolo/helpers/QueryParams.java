package com.yolo.helpers;

public class QueryParams {
	private Integer page; 
	private Integer size; 
	private String sortBy; 
	private String sortDirection;
	private String search;

	public QueryParams() {
		super();
	}

	public QueryParams(Integer page, Integer size, String sortBy, String sortDirection, String search) {
		super();
		this.page = page;
		this.size = size;
		this.sortBy = sortBy;
		this.sortDirection = sortDirection;
		this.search = search;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public int getSize() {
		return (size == null || size <= 0 || size > 100) ? 100 : size;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getPage() {
		return (page == null || page < 1) ? 1 : page;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSortDirection() {
		return (sortDirection == null || sortDirection.isBlank()) ? "asc" : sortDirection.toLowerCase();
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
