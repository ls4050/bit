package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData2 {
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
				// 동일한 sql인데 데이터만 바꾸면된다? => preparedStatement가 적합
				// 바이너리 파일 처리 = 무조건 preparedStatment
				// 동적으로 처리하기 때문에 더 빠르다
				PreparedStatement pstmt = conn.prepareStatement("insert into student values (?, ?)"); // ? : 동적 파라미터
				// 메서드 이름은 prepareStatement
				// 인터페이스 명은 preapredStatement
				Scanner scan = new Scanner(System.in);){
			while(true) {
				System.out.print("학생 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("학생 점수를 입력하세요 : ");
				int score = Integer.parseInt(scan.nextLine());
				pstmt.setString(1,  name);
				pstmt.setInt(2, score);
				pstmt.executeUpdate(); // 얘를 무조건 해야 db테이블에 올라간다
				System.out.println("student 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				} 
				System.out.println("student 테이블 데이터 삽입 작업 종료");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
