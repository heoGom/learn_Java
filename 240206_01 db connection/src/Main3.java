import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// pets 테이블에 레코드 1행 추가
// 이름: 피카추
// 종   : 쥐
// 나이: 3
public class Main3 {
	public static void insertPet(String name, String species, int age) {
		String url = "jdbc:mysql://localhost:3306/my_db";
		String id = "root";
		String password = "root";
		
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			stmt = conn.createStatement();

			String sql = "INSERT INTO pets(name, species, age) VALUES('"+name+"', '"+species+"', "+age+");";
			System.out.println("SQL :" + sql);


			int rowResult = stmt.executeUpdate(sql);
			if (rowResult == 1) {
				System.out.println("레코드 추가 성공");
			} else {
				System.out.println("레코드 추가 실패");
			}
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결 실패");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("성공");
		} catch (ClassNotFoundException e) {
			System.out.println("실패!");
		}

		insertPet("파이리", "도마뱀", 4);
		insertPet("피존투", "비둘기", 5);
	}
}
