package base;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Random ran = new Random();
		int nR = ran.nextInt(5)+1;
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("전달된 값 : " + nR + "\n추출된 값 : " + num);
//		out.print(ran);
		if(nR==num) {
			RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/success.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/fail.html");
			rd.forward(request, response);
		}
	}

}
