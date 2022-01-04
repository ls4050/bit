package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String p1 = request.getParameter("p1");
		// 변환할 숫자가 없어서 오류발생
		int p2 = Integer.parseInt(request.getParameter("p2"));
		// 하나의 p3 네임에 여러개의 벨류가 올 때 getParameterValues
		String p3[] = request.getParameterValues("p3"); 
		out.print("<ul>");
		out.print("<li>p1 : "+ p1 +"</li>");
		out.print("<li>p2 : "+ p2 +"</li>");
		// 널이 아니라 비어있는 배열리턴함
		for(int i=0; i < p3.length; i++)
			out.print("<li>p3["+i+"] : "+ p3[i] +"</li>");
		// 브라우저에게 내보내겠다 하면 무조건 out.print사용
		out.print("</ul>");
		// a태그는 hyperLink 쓰고싶을 때 사용
		// href에는 옮겨가고싶은 이미지나 링크 입력
		out.print("<a href='/edu/htmlexam/queryservlettest.html'>입력화면으로</a>");
		out.close();		
	}
}




