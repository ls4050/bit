package controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;
@WebServlet("/sharetest3")
public class ShareTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		// getServletConetext()는 Httpservlet이라는 부모클래스가 갖고있는 것임
		// tomcat이 edu라는 servletContext를 만듬
		
		ServletContext context = getServletContext(); 
		if(context.getAttribute("objapp") == null) {
			context.setAttribute("objapp", new CountVO());
		}
		CountVO vo = (CountVO)context.getAttribute("objapp");
		vo.setNumber(param);
		
		request.getRequestDispatcher("/jspsrc/share3.jsp").
		              forward(request, response);
	}
}
// 보관되있는 객체 가져올때 getAttribute
// 객체 생성 setAttribute
// 객체 삭제 removeAttribute