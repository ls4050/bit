package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {
	
	//랜덤boolean 생성방법 1
	private static final Random rand = new Random();
	public static boolean getBoolean() {
        return getBoolean(rand);
    }
	public static boolean getBoolean(Random r) {
        return r.nextBoolean();
    }
	
	//랜덤boolean 생성방법 2
	Random rd = new Random();
	boolean falg = rd.nextBoolean();
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		ResultSet rs = null;
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				){
			if(getBoolean()) {
				rs = stmt.executeQuery("select concat(ename, \"직원의 월급은\") 직원명, concat(format(sal, 0), \"원입니다.\") 급여 from emp;");
				while (rs.next()) {
					System.out.println(rs.getString("직원명") + rs.getString("급여"));
				}
			} else {
				rs = stmt.executeQuery("select concat(ename, \"직원은 \") 직원명, date_format(hiredate, \"%Y년 %m월 %d일에 입사하였습니다.\") 입사년도 from emp order by hiredate;");
				while (rs.next()) {
					System.out.println(rs.getString("직원명") + rs.getString("입사년도"));
				}
			}
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		} finally {
			try {
				if(rs!= null) 
					rs.close();
			} catch(SQLException sqle2) {
				sqle2.getMessage();
			}
		}
	}
}
