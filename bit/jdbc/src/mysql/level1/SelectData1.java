package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData1 {
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
		// 트라이 블록이 수행이 끝날때 자동으로 close가 된다
		// try ~ catch with resource 구문
		// try 소괄호안에 선언될 수 있는 놈 = closable인터페이스를 상속받는 객체만 사용 가능 (닫는 기능이 있는 애들)
		// 변수 선언과 객체생성을 동시에 해야한다 
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getString("name") + "학생은 " + rs.getInt("score") + "점 입니다.");
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		// close 처리를안함
	}
}
