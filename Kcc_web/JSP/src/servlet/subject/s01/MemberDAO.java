package servlet.subject.s01;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.subject.s01.AuthMapper;
import servlet.dao.BoardDao2;

public class MemberDAO {

	private static MemberDAO dao;

	public static MemberDAO getInstance() {

		if (dao == null) {
			dao = new MemberDAO();
		}

		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}

	// 회원가입
	public int signUp(MemberVO memberVO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(AuthMapper.class).signUp(memberVO);

			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}

	// 로그인
	public MemberVO signIn(MemberVO memberVO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MemberVO loginMember = null;

		try {
			loginMember = sqlSession.getMapper(AuthMapper.class).signIn(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return loginMember;
	}
}
