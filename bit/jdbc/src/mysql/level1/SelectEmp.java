package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmp {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 문자열에 주어진 클래스를 찾지 못할때
			// class not found exception은 반드시 해줘야하는 예외처리
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 드라이버에서 제공하는 자식객체를 사용하는 것
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println(conn.getClass().getName());
			stmt = conn.createStatement();
			System.out.println(stmt.getClass().getName());
			rs = stmt.executeQuery("select * from course1"); //자식객체를 통해 부모객체 참조 = 다형성
			System.out.println(rs.getClass().getName());
			while (rs.next()) {
				System.out.println(rs.getString("name") + ", " + rs.getString("phone") + rs.getInt("age")+ ", ");
			}
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		} finally {
			try { // rs stmt conn이 null이 아닐때 close하는 게 좋다
				// 무조건 null처리 해라(중요)
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				System.out.println(se2.getMessage());
			}
		}
	}
}