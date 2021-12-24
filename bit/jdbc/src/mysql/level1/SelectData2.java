package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectData2 {
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
				PreparedStatement pstmt = conn.prepareStatement("select score from student where name = ?");
				Scanner scan = new Scanner(System.in);){
		    System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
		    pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery(); // 만약 셀렉에 없는 것을 참조하려면 비어있는 Resultset객체를 불러온다, 판단은 next에서 판단함
			if(rs.next()) // 없으면 false;, 단 한번 수행시킨 next가 false라는 것은 데이터가 없다는 것을 의미
				System.out.println(name + "학생의 점수 : " + rs.getInt("score"));
			 else 			
				 System.out.println(name + "학생에 대한 데이터가 없습니다.");
			 System.out.println("수행 종료...");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
