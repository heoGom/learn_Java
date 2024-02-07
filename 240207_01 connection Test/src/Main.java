import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.MySqlConnectionProvider;
import static dbutil.MySqlConnectionProvider.*;

public class Main {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select 200 as val");

			if (rs.next()) {
				int result = rs.getInt("val");
				System.out.println(result == 200 ? "테스트 통과" : "테스트 실패");
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
