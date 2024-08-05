package servlet.subject.s01;

import java.io.Serializable;

public class MemberVO implements Serializable {

	private int seq;
	private String email;
	private String password;
	private String name;

	public MemberVO() {
		super();
	}

	public MemberVO(int seq, String email, String password, String name) {
		this.seq = seq;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public MemberVO(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public MemberVO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberVO [seq=" + seq + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}

}
