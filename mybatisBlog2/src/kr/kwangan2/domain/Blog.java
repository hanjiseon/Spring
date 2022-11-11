package kr.kwangan2.domain;

import java.io.Serializable;
import java.util.List;


public class Blog implements Serializable {

	private static final long serialVersionUID = 158511151214L;

	private int blogId;
	private String blogName;
	private String blogTitle;
	private Author author;
	private List<Comm> comms;
	private int fkAuthorId;
	
	public Blog(Integer blogId) {
		this.blogId = blogId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comm> getComms() {
		return comms;
	}

	public void setComms(List<Comm> comms) {
		this.comms = comms;
	}

	public int getFkAuthorId() {
		return fkAuthorId;
	}

	public void setFkAuthorId(int fkAuthorId) {
		this.fkAuthorId = fkAuthorId;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName + ", blogTitle=" + blogTitle + ", author=" + author
				+ ", comms=" + comms + ", fkAuthorId=" + fkAuthorId + "]";
	}

}
