package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String pid=request.getParameter("pid");
		String pidS = pid.substring(1);
		int pidN = Integer.parseInt(pidS);
		out.printf("<h1>선택한상품 : %s</h1>", pid);
		out.printf("<img src=/edu/images/%d.png>", pidN);//image
		out.print("<hr>");
//		out.print("<a href='/edu/htmlexam/productlog.html'>상품 선택 화면으로</a>");
		// 아래 방법도 이전화면으로 가는 방법중 하나
		out.print("<a href="+request.getHeader("referer")+">상품 선택 화면으로</a>");
	}

}
