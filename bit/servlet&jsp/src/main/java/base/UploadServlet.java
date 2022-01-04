package base;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
//location에 업로드할 파일 path를 저장
// 멀티파트 컨피그 없으면 getParts오류난다
@MultipartConfig(location = "c:/Temp/uploadtest")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String path = "c:/Temp/uploadtest";
		File isDir = new File(path);
		// 패쓰가 존재하냐 안하냐를 따진 후, 존재하지않으면 디렉토리생성
		if (!isDir.isDirectory()) {
			isDir.mkdirs();
		}
		// 멀티파트로 전달될때는 반드시 
		// 전달된 파트개수만큼 뽑아내야한다
		// 컬렉션 객체에 파트를 담는다
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			// 클라이언트에서 전송된 파일이름 추출
			// 얘는 String "" 을 반환함 , 파일타입자체도 null임 (가리키고있는게 없으므로)
			String fileName = part.getSubmittedFileName();
			// 업로드 되는 파일이 있냐 없냐
			// 두개의 조건을 따져줘야한다 (벨류, 문자열)
			// myname, myphone, myfile 최소한 세개의 파트는 넘어오지만 value가 비어있는 것
			if (fileName != null && !fileName.equals("")) {
				// 1970년1월1일 0시 기준 지금까지의 밀리세컨드
				part.write(System.currentTimeMillis()+"_"+fileName); 
				out.print("업로드한 파일 이름: " + fileName + "<br>");
				out.print("크기: " + part.getSize() + "<br>");
				out.print("file 업로드 함");
			} else {
				//전달된 the age, the author 이름 추출해서
				// 벨류를 가져온다
				out.print("file 업로드 안함");
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print(partName + " : " + fieldValue + "<br>");
			}
		}
		out.close();
	}
}
