package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDataLab {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다.");
			return;
		}
		String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery("select id, name, title, date_format(meetingdate, \"%Y년 %m월 %d일 %H시 %i분\") 날짜 from meeting;");
			while(rs.next()) {
				System.out.println("[id가 " + rs.getInt("id") + "인 친구]");
				System.out.println("친구이름 : " + rs.getString("name"));
				System.out.println("미팅목적 : " + rs.getString("title"));
				System.out.println("미팅시간 : " + rs.getString("날짜"));
			}
		}catch(SQLException sqle) {
			System.out.println("sql오류발생 : " + sqle.getMessage());
		}
	}
}


/*
 *
 * meeting 테이블의 데이터를 모두 일고 다음과 같이 출력하는 JDBC 프로그램을 구현한다.
예외 발생시 적당한 메시지를 출력한다.
[id가 1인 친구]
친구이름 : 둘리
미팅목적 : 자바 공부
미팅시간 : 2021년 12월 21일 13시 09분
[id가 2인 친구]
친구이름 : 또치
미팅목적 : 영화 보기
미팅시간 : 2021년 12월 25일 12시 00분
[id가 3인 친구]
친구이름 : 도우너
미팅목적 : PC방
미팅시간 : 2022년 1월 1일 00시 00분
 * 
*/