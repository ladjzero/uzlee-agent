package ladjzero.hipda.core.api;

import com.google.gson.Gson;
import ladjzero.hipda.core.parsers.Parser;

/**
 * Created by chenzhuo on 2017/4/23.
 */
public class Response<T> {
	private static Gson gson = new Gson();
	private boolean success = true;
	private String message;
	private Meta meta;

	@Override
	public String toString() {
		return gson.toJson(this);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private T data;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public static class Meta {
		@Override
		public String toString() {
			return gson.toJson(this);
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getFormhash() {
			return formhash;
		}

		public void setFormhash(String formhash) {
			this.formhash = formhash;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}

		public Integer getUnread() {
			return unread;
		}

		public void setUnread(Integer unread) {
			this.unread = unread;
		}

		public Integer getUid() {
			return uid;
		}

		public void setUid(Integer uid) {
			this.uid = uid;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		private String userName;
		private Integer uid;
		private String formhash;
		private String hash;
		private String code = Parser.CODE_GBK;
		private Integer unread;
	}
}
