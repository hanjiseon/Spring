package mybatis.test.dto;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 2467564315486L;

	private int sid;
	private String email;
	private String name;
	private String passwd;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [sid=" + sid + ", email=" + email + ", name=" + name + ", passwd=" + passwd + "]";
	}

}