package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ProductVO;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		/*
		 * getSession은 세션이 있는지 없는지 세션id를 통해 체크를 한다음,
		 * 있으면 기존 세션을 사용하고, 없으면 세션객체를 생성한다.
		 */
		HttpSession session = request.getSession();
		// 등록이 안돼있으면 null 반환 (아래 조건은 최초 요청시에만 참이 된다)
		if(session.getAttribute("objProduct")==null) {
			session.setAttribute("objProduct", new ProductVO());
		}
		ProductVO vo = (ProductVO)session.getAttribute("objProduct");
		if(pid.equals("p001")&&!pid.isEmpty()) {
			vo.setApple(1);			
		} else if (pid.equals("p002")&&!pid.isEmpty()) {
			vo.setBanana(1);			
		} else if (pid.equals("p003")&&!pid.isEmpty()) {
			vo.setHalabong(1);			
		} else {
			request.getRequestDispatcher("/edu/htmlexam/product.html").forward(request, response);
		}
		
		request.getRequestDispatcher("/jspsrc/productView.jsp").forward(request, response);
		
	}
}
