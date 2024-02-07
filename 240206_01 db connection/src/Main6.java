import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {
	public static void getByName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
			stmt = conn.createStatement();

			String query = "SELECT name, continent, surfaceArea, population FROM country" + " WHERE name = '" + name
					+ "'";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String nname = rs.getString("name");
				String continent = (String) rs.getObject("continent");

				double surfaceArea = rs.getFloat("surfacearea");
				int population = rs.getInt("population");

				System.out.printf("%s %s %f %d\n", nname, continent, surfaceArea, population);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getByName("south korea");
		getByName("north korea");
	}

}
