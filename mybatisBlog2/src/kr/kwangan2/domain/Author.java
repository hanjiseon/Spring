package kr.kwangan2.domain;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 15895741214L;

	private int authorId;
	private String authorName;

	public Author() {
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}

}
