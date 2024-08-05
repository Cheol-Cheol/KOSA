package servlet.subject.s01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signIn")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		MemberVO memberVO = new MemberVO(email, password);
		MemberVO loginMember = MemberDAO.getInstance().signIn(memberVO);

		if (loginMember != null) {
			// 로그인 성공
			request.getSession().setAttribute("auth", loginMember);
			// 상품 리스트 가져오기
			List<ProductVO> products = ProductDAO.getInstance().productList();
			request.setAttribute("productList", products);

			request.getRequestDispatcher("/subject/s01/main.jsp").forward(request, response);
		} else {
			// 로그인 실패
			request.getRequestDispatcher("/subject/s01/login.html").forward(request, response);
		}
	}

}
