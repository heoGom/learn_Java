import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.MySqlConnectionProvider;

public class TestPreparedStmt {
	public static void main(String[] args) {
//		petId int AI PK 
//		name varchar(15) 
//		species varchar(15) 
//		age int
		
		String name = "냥냥이";
		String species = "고양이";
		int age = 4;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MySqlConnectionProvider.getConnection();
			
			String sql = "INSERT INTO pets (name, species, age) VALUES (?, ?, ?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, name);
			stmt.setString(2, species);
			stmt.setInt(3, age);
			
			int result = stmt.executeUpdate();
			System.out.println(result + "행 추가");
			
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				System.out.println("생성된 키 값 : " + rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlConnectionProvider.closeResultSet(rs);
			MySqlConnectionProvider.closeStatement(stmt);
			MySqlConnectionProvider.closeConnection(conn);
		}
	}
}








