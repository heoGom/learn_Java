import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class PersonDAOImpl implements PersonDAO {

	@Override
	public int insert(Person p) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = MySqlConnectionProvider.getConnection();

			String sql = "INSERT INTO person (name, age) VALUES('" + p.getName() + "'," + p.getAge() + ")";

			System.out.println("SQL 명령 확인 : " + sql);
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlConnectionProvider.closeStatement(stmt);
			MySqlConnectionProvider.closeConnection(conn);
		}

		return 0;
	}

	@Override
	public List<Person> getAll() {
		List<Person> list = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlConnectionProvider.getConnection();
			String query = "SELECT * FROM PERSON";
			System.out.println("SQL 명령 확인 : " + query);

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");

				list.add(new Person(name, age));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			MySqlConnectionProvider.closeResultSet(rs);
			MySqlConnectionProvider.closeStatement(stmt);
			MySqlConnectionProvider.closeConnection(conn);
		}

		return list;
	}

}
