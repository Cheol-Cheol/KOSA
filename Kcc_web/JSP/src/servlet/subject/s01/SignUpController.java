package servlet.subject.s01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		MemberVO memberVO = new MemberVO(email, password, name);
		int re = MemberDAO.getInstance().signUp(memberVO);

		if (re > 0) {
			response.sendRedirect("/subject/s01/login.html");
		} else {
			System.out.println("회원가입 실패");
		}
	}

}
