package com.ladjzero.uzlee.parser;

import java.lang.*;
import java.util.ArrayList;

/**
 * Created by chenzhuo on 16-2-11.
 */
public class Threads extends ArrayList<java.lang.Thread> {
	public Meta meta = new Meta();

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public static class Meta {
		private boolean mHasNextPage;
		private int mPage;

		public boolean hasNextPage() {
			return mHasNextPage;
		}

		public void setHasNextPage(boolean hasNextPage) {
			mHasNextPage = hasNextPage;
		}

		public int getPage() {
			return mPage;
		}

		public void setPage(int page) {
			mPage = page;
		}
	}
}
