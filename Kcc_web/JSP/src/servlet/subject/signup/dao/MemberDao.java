package servlet.subject.signup.dao;

import servlet.subject.signup.model.Member;

public class MemberDao {
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public void insert(Member m) {
		System.out.println(m);
	}
}
