import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class PersonDAOImpl implements PersonDAO {
	//Singleton Pattern
	private static PersonDAOImpl instance = new PersonDAOImpl();
	
	public static PersonDAOImpl getInstance() {
		return instance;
	}
	
	private PersonDAOImpl() {}

	@Override
	public Person getByPk(String name, Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlConnectionProvider.getConnection();

			String query = "SELECT * FROM PERSON WHERE NAME = '" + name + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {

				return resultMapping(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터 베이스 작업 중 문제가 발생함. 관리자 문의요망.");
		} finally {
			MySqlConnectionProvider.closeResultSet(rs);
			MySqlConnectionProvider.closeStatement(stmt);
		}

		return null;
	}

	@Override
	public int insert(Person p, Connection conn) {
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

				list.add(resultMapping(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터 베이스 작업 중 문제가 발생함. 관리자 문의요망.");
		} finally {

			MySqlConnectionProvider.closeResultSet(rs);
			MySqlConnectionProvider.closeStatement(stmt);
			MySqlConnectionProvider.closeConnection(conn);
		}

		return list;
	}

}
