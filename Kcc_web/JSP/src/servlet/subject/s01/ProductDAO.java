package servlet.subject.s01;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.subject.s01.ProductMapper;

public class ProductDAO {

	private static ProductDAO dao;

	public static ProductDAO getInstance() {

		if (dao == null) {
			dao = new ProductDAO();
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

	// 상품 리스트 가져오기
	public List<ProductVO> productList() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ProductVO> products = new ArrayList();

		try {
			products = sqlSession.getMapper(ProductMapper.class).productList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return products;
	}
}
