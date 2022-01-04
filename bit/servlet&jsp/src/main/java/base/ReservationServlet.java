package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("rname");
			String forest = request.getParameter("forest");
			String rdate = request.getParameter("rdate");
			//여러개의 벨류가 올때는 getParameterValues
			String[] additional = request.getParameterValues("additional");
			int len = additional.length;
			System.out.println(rdate);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			out.print("<h1>" + name + "님의 예약 내용</h1>");
			out.print("<hr>");
			out.print("<ul>");

			out.print("<li>휴양림 : ");
			out.print(forest);
			out.print("</li>");
			out.print("<li>추가 요청 사항 : ");
			for (int i = 0; i < len; i++) {
				if (i == len - 1) {
					out.print(additional[i] + "</li>");
				} else {
					out.print(additional[i] + ", ");
				}
			}
			LocalDate date = LocalDate.parse(rdate);
			out.print(String.format("<li>예약날짜 : %1$tY년 %1$tm월 %1$td일</li></ul>", date));
			out.close();
	}
}
