package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(action != null && action.equals("naver")) {
			response.sendRedirect("http://www.naver.com/");			
		} else if (action != null && action.equals("daum")) {
			response.sendRedirect("http://www.daum.net/");						
		} else if (action != null && action.equals("google")) {
			response.sendRedirect("http://www.google.com/");									
		} else {
			out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");
		}
	}
}