package base;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션객체를 준비하는 놈임 만드는애 아님 X
		response.setContentType("text/html; charset=UTF-8");
		
		Random ran = new Random();
		int nR = ran.nextInt(5)+1;
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("전달된 값 : " + nR + "\n추출된 값 : " + num);
		RequestDispatcher rd = null;
		// 세션벨류안에 보관되는 것은 객체여야한다
		// 전달한 객체의 참조값이 보관되는 것
		// 하나의 벨류를 주소값을통해 공유하는 개념
		if(session.getAttribute("cnt") == null) 
			session.setAttribute("cnt", new int[1]);
		int data[] = (int[])session.getAttribute("cnt");
		if(data[0]!=3&&nR==num) {
			data[0]=3;
			rd = request.getRequestDispatcher("/jspsrc/success.jsp");
			rd.forward(request, response);
		} else if (data[0]!=3&&nR!=num) {
			data[0]++;
			rd = request.getRequestDispatcher("/jspsrc/fail.jsp");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/jspsrc/impossible.jsp");
			rd.forward(request, response);
		}
		
	}

}
