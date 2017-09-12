package ladjzero.hipda.core.entities;

import java.util.List;

/**
 * Created by chenzhuo on 16-2-11.
 */
public class Threads {
	public Threads(List<Thread> threads) {
		records = threads;
	}

	private boolean hasNextPage;
	private int page;

	public boolean getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Thread> getRecords() {
		return records;
	}

	public void setRecords(List<Thread> records) {
		this.records = records;
	}

	private List<Thread> records;
}
