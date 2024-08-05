package servlet.subject.s01;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToCartController() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String[] selectedProducts = request.getParameterValues("selectedProducts");
		MemberVO loginMember = (MemberVO) request.getSession().getAttribute("auth");

		if (selectedProducts != null) {
			for (String productId : selectedProducts) {
				CartVO item = new CartVO(loginMember.getSeq(), Integer.parseInt(productId));
				CartDAO.getInstance().addToCart(item);
			}
		} else {
			System.out.println("선택된 상품이 없습니다.");
		}

		List<CartVO> cartList = CartDAO.getInstance().getCartById(loginMember.getSeq());
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("/subject/s01/cart.jsp").forward(request, response);
	}

}
