package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if(request.getParameter("num1").equals("")||request.getParameter("num2").equals("")) {
			request.setAttribute("objcalc", "나눗셈 연산시 두 번째 숫자는 0 일 수 없습니다!!");
			request.getRequestDispatcher("/jspsrc/errorResultEL.jsp").forward(request, response);
		} else {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			int result = 0;
			
			if(num2!=0) {
				if (op.equals("+")) {
					result = num1 + num2;
				} else if (op.equals("-")) {
					result = num1 - num2;
				} else if (op.equals("*")) {
					result = num1 * num2;
				} else if (op.equals("/")) {
					result = num1 / num2;
				}
				request.setAttribute("objcalc", result);
				request.getRequestDispatcher("/jspsrc/calcResultEL.jsp").forward(request, response);
			} else {
				request.setAttribute("objcalc", "나눗셈 연산시 두 번째 숫자는 0 일 수 없습니다!!");
				request.getRequestDispatcher("/jspsrc/errorResultEL.jsp").forward(request, response);
			}
		}
		
		
		

		

		
	}

}
