package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String filename = "";
		String contentType = "";
		// uri가 무엇을 요청하는지에 따라 다르게 설정해줄 수 있음 
		// html말고도 다른것도 응답할 수 있음을 보여줌
		if (uri.endsWith("getHTML")) {
			filename = "c:/Temp/sample.html";	
			contentType = "text/html; charset=utf-8";
		} else if (uri.endsWith("getXML")) {
			filename = "c:/Temp/sample.xml";	
			contentType = "application/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) {
			filename = "c:/Temp/sample.json";	
			contentType = "text/json; charset=utf-8";
		} else {
			filename = "c:/Temp/trans_duke.png";	
			contentType = "image/png";
		}
		File f = new File(filename);
		// 이미지는 무조건 fileinputStream 사용
		// inputstream(입력용 바이트 스트림=이미지를 읽어올것이다), outstream(출력용 바이트 스트림) = byte단위 스트림(이미지)
		// writer(입력용 텍스트), reader  = txt단위 (텍스트)
		FileInputStream fis = new FileInputStream(f);// 파일을 읽기모드로 객체생성한 것
		response.setContentType(contentType);
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()];
			ServletOutputStream sos = response.getOutputStream(); // servletoutputstream 객체 생성
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {
			InputStreamReader isr = new InputStreamReader(fis, "utf-8"); //바이트 스트림 => 문자 스트림으로 변환해주는 브릿지역할
			BufferedReader br = new BufferedReader(isr); // io성능 높이려고	
			PrintWriter out = response.getWriter();
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
