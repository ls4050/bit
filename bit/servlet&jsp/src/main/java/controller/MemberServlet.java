package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected static String format(String str) {
		return str.replaceFirst("([0-9]{3})([0-9]{4})([0-9]{4})$","$1-$2-$3");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8"); jsp가 응답하기때문에 필요없다.
		MemberVO vo = new MemberVO();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if (name == null || name.isEmpty()) {
			name = "없음";
		}
		if (phone == null || phone.isEmpty()) {
			phone = "없음";
		}
		if (id == null || id.isEmpty()) {
			id = "없음";
		}
		if (pwd == null || pwd.isEmpty()) {
			pwd = "없음";
		}
		

		vo.setId(id);
		vo.setName(name);
		vo.setPhone(MemberServlet.format(phone));
		vo.setPwd(pwd);

		request.setAttribute("objMember", vo);
		request.getRequestDispatcher("/jspsrc/MemberViewEL.jsp").forward(request, response);
	}

}
