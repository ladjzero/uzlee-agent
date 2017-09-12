package ladjzero.hipda.core.entities;

import java.util.List;

/**
 * Created by ladjzero on 2015/4/6.
 */

public class Posts {
	public Posts(List<Post> posts) {
		records = posts;
	}

	private int fid;
	private int page;
	private int totalPage;
	private boolean hasNextPage;
	private int orderType;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;

	public List<Post> getRecords() {
		return records;
	}

	public void setRecords(List<Post> records) {
		this.records = records;
	}

	private List<Post> records;
}
