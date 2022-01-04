/*
 * 서블릿은 반프레임워크임 = 
 * get을 사용하려면 doGet라이딩, 서블릿 사용하려면 httpservlet상속, post 사용하려면 dopost오버라이딩 이런 것들을 정해둠
 * 우리는 정의해둔대로 사용해야함
 */

package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//anotation구문으로 지정
// /edu/first가 수행되면 얘가 수행되는 것
// 서블릿은 mapping명으로 찾는다
// html은 webapp에서 찾는다
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 앞에 있는 애는 요청, 뒤에있는애는 응답
		// 개행 문자를 하나의 공백으로 받아들임 = print나 println이나 상관없다
		// setContentType = 브라우저에게 타입을 알려주는 메서드, 지정을 잘 해줘야한다.
		// 2초 정도기다렸다가 봐라
		// text를 plain형태로 응답해줄거냐 html로 응답해줄것인가
		// text/html   test/plain 이런 놈들 = mime타입(컨텐츠가 어떤타입인지 알리는 정해진 타입의 규격)
		response.setContentType("text/html; charset=UTF-8");
//		response.setContentType("text/plain; charset=UTF-8");
		// getOutputStream = 이미지
		// text를 출력하고싶으면 PrintWriter
		// client의 출력 객체 out을 통해 나가야 browser에 출력가능
		PrintWriter out = response.getWriter();
		out.print("<h1>FirstServlet 수행 완료</h1>");
		out.print("<hr>");
		out.print("<h2>요청 방식:"+request.getMethod()+"<h2>");
		//http://localhost:8080/edu/first?name=이원석
		//name 없이 주소 입력하면 null뜸
		out.print("<h2>반가워요..."+request.getParameter("name")+"님!!<h2>");
		
		// close는 반드시
		out.close();
		System.out.println("서블릿에서의 표준 출력은 어디로 나갈까용?");
	}

}
