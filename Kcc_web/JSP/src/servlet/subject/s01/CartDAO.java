package servlet.subject.s01;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.subject.s01.AuthMapper;
import mapper.subject.s01.CartMapper;

public class CartDAO {

	private static CartDAO dao;

	public static CartDAO getInstance() {

		if (dao == null) {
			dao = new CartDAO();
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

	// 장바구니 추가
	public int addToCart(CartVO cartVO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(CartMapper.class).addToCart(cartVO);

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

	public List<CartVO> getCartById(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<CartVO> cartList = new ArrayList();

		try {
			cartList = sqlSession.getMapper(CartMapper.class).addToCart(cartVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return cartList;
	}
}
