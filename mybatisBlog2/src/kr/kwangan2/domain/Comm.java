package kr.kwangan2.domain;

import java.io.Serializable;


public class Comm implements Serializable {
	
	private static final long serialVersionUID = 1486521214L;
	
	private int commId;
	private String commTitle;
	private String commContent;
	private int fkblogId;
	
	public Comm() {
	}
	
	public int getCommId() {
		return commId;
	}
	public void setCommId(int commId) {
		this.commId = commId;
	}
	public String getCommTitle() {
		return commTitle;
	}
	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}
	public String getCommContent() {
		return commContent;
	}
	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}
	public int getFkblogId() {
		return fkblogId;
	}
	public void setFkblogId(int fkblogId) {
		this.fkblogId = fkblogId;
	}
	@Override
	public String toString() {
		return "Comm [commId=" + commId + ", commTitle=" + commTitle + ", commContent=" + commContent + ", fkblogId="
				+ fkblogId + "]";
	}
	
	

}
