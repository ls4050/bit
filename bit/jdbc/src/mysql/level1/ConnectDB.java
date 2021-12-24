package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
	public static void main(String args[]) {
		try {
			//DriverManager로 어떤 DB를 사용할 것인지 드라이버를 로드한다
			//각 DB마다 고유의 드라이버 이름이 있다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//jdbc url
			//url : unifrom resource locator, 어떤 자원이든 위치를 알릴 때 단일화 시킨 단위
			//http url : 우리가 보통 알고 있는 url
			//jdbc url : 어떤 db서버를 어떤 driver로 접속할 것인지를 알리는 단일화된 형식
			String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "1234";
			Connection conn = DriverManager.getConnection(url, user, passwd);
			conn.close(); // 연결 끊는 것, 더이상 db와 연결할 필요 없으면 close 꼭 해줘라
			System.out.println("MYSQL 연결 성공");
		} catch (Exception e) {
			System.out.println("MYSQL 연결 실패");
			System.out.print("사유 : " + e.getMessage());
		}
	}
}