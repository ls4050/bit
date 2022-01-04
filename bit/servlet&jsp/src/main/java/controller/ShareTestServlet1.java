package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;
@WebServlet("/sharetest1")
public class ShareTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num")); // 쿼리를 주고 요청해야한다
		CountVO vo = new CountVO();
		vo.setNumber(param);
		request.setAttribute("objreq", vo);
		request.getRequestDispatcher("/jspsrc/share1.jsp").
		              forward(request, response);
	}
}

/*
 * CountVO > servlets > jsp
 * CountVO에게 전달한num을 setNumber
 * objreq라는 이름으로 count 객체를 보관
 * request dispatcher를 통해 share1한테 요청 넘김
 * 요청 스코프이므로 생성될때마다 사라진다. (값이 안올라감)
 */
