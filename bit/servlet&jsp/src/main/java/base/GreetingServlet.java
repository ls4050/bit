package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		LocalDateTime currentDateTime = LocalDateTime.now();
		String str = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
		String guestname = request.getParameter("guestname");
		if(guestname==null) {
			guestname="손";
		}
		
		out.print("<h2>"+guestname+"님 반가워요.. 오늘은 "+ str+" 입니다.<h2>");
		
//		Date date = new Date();
//		SimpleDateFormat ft = new SimpleDateFormat ("E");
//		out.print("<h2>"+request.getParameter("guestname")+"님 반가워요.. 오늘은 "+ ft.format(date)+"요일 입니다.<h2>");
		out.close();
	}

}
