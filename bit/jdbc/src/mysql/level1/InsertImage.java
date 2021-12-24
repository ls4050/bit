package mysql.level1;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO imgtest (filename, filecontent) VALUES (?, ?)")){
			// auto increament 설정된 것
			System.out.print("저장할 이미지 파일명을 절대 패스로 입력하세요 : ");
			String name = scan.nextLine();
			File imgFile = new File(name);
			if (imgFile.exists()) {
				int pointIndex = imgFile.getName().indexOf('.'); // 파일확장자시작위치
				String imgName = imgFile.getName().substring(0, pointIndex); // 파일확장자 시작위치인 . 앞까지 짤라버림
				System.out.println(imgFile.getName().substring(0, pointIndex)); // 파일명 출력
				FileInputStream fin = new FileInputStream(imgFile); // inputstream = 파일 읽어오는 스트림
				pstmt.setString(1, imgName); 
				pstmt.setBinaryStream(2, fin, (int)imgFile.length()); // 바이너리스트림을 통해 디비에 이미지 넣어줌, 이미지파일을 얼만큼 읽어올것이냐 (사이즈 전체 다 읽어오려면 length를 통해 세번째 인자에 설정)
				pstmt.executeUpdate(); 
				System.out.println("이미지 삽입 성공");
			} else {
				System.out.println("[오류] 이미지가 존재하지 않음");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
