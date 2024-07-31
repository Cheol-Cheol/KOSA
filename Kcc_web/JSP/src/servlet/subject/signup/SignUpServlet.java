package servlet.subject.signup;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String[] hobbies = request.getParameterValues("hobby");

		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		request.setAttribute("hobby", hobbies);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/signup.jsp");
		dispatcher.forward(request, response);
	}

}
