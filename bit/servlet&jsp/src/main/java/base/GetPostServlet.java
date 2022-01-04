package base;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost")
public class GetPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>요청 방식 : " + request.getMethod() + "</h2>");
		out.print("<h2>Query 문자열 : " + request.getParameter("name") + "</h2>");
		out.close();
		System.out.println("GET 방식 수행");
	}
	// 서블릿은 get post 방식 바꾸기가 편리함 그냥 이름만 바꾸면 된다
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 전달되는 방식의 차이때문에 post방식으로 한글을 파라미터로 주기위해서는 아래 한줄 코드가 필요하다.
		 request.setCharacterEncoding("UTF-8");
		out.print("<h2>요청 방식 : " + request.getMethod() + "</h2>");
		//post는 Query문자열이 아닌 요청 파라미터라고 하는것이 맞다
		out.print("<h2>요청 파라미터 : " + request.getParameter("name") + "</h2>");
		// 서블릿은 복잡한 부분을 WAS가 대신 해줌
		// URL에 전달되는 네임벨류쌍의 요청파라미터가 안보인다
		out.close();
		System.out.println("POST 방식 수행");
	}
}
