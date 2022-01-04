package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitorget")
public class VisitorGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("stname");
		String op = request.getParameter("op");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy년 MM월 dd일");
		out.print("<h1>" + name + " 님이 " + ft.format(date) + "에 남긴 글입니다" + "</h1>");
		out.print("<hr>");

		out.print("<br> 내용 : " + op + "</br>");

		out.print("<a href='/edu/htmlexam/visitorForm.html'>" + "입력화면으로</a>");

		out.close();
	}

}
