package quanlidetaikhoahoc.responseData;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import quanlidetaikhoahoc.domain.Views;

public class PaginatedResponse<T> {

	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private int totalPages;
	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private int totalElement;
	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private int page;
	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private int pageSize;
	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private List<T> data;
	
	public int getTotalPage() {
		return totalPages;
	}
	public void setTotalPage(int totalPage) {
		this.totalPages = totalPage;
	}
	public int getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(int totalElement) {
		this.totalElement = totalElement;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getDatas() {
		return data;
	}
	public void setDatas(List<T> datas) {
		this.data = datas;
	}
	
	
}
