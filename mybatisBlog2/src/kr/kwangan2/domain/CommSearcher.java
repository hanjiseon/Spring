 package kr.kwangan2.domain;

import java.io.Serializable;

public class CommSearcher implements Serializable {

	private static final long serialVersionUID = 158524851214L;

	private int fkblogId;
	private String searchKey;
	private String searchValue;

	public CommSearcher() {
	}

	public int getFkblogId() {
		return fkblogId;
	}

	public void setFkblogId(int fkblogId) {
		this.fkblogId = fkblogId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "CommSearcher [fkfkblogId=" + fkblogId + ", searchKey=" + searchKey + ", searchValue=" + searchValue
				+ "]";
	}

}