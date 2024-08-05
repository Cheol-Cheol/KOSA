package mapper.subject.s01;

import servlet.subject.s01.MemberVO;

public interface AuthMapper {
	int signUp(MemberVO memberVO);

	MemberVO signIn(MemberVO memberVO);
}
