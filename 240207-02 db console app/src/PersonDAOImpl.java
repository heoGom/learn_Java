import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class PersonDAOImpl implements PersonDAO {
	// Singleton Pattern
	private static PersonDAOImpl instance = new PersonDAOImpl();

	public static PersonDAOImpl getInstance() {
		return instance;
	}

	private PersonDAOImpl() {
	}

	@Override
	public Person getByPK(String name, Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM person WHERE name = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);

			rs = stmt.executeQuery();
			if (rs.next()) {
				return resultMapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터 베이스 작업 중 문제가 발생하였습니다. 관리자에게 문의하세요.");
		} finally {
			MySqlConnectionProvider.closeResultSet(rs);
			MySqlConnectionProvider.closeStatement(stmt);
		}

		return null;
	}

	@Override
	public int insert(Person p, Connection conn) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO person (name, age)" + " VALUES (?,?)";

			System.out.println("SQL 명령 확인: " + sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터 베이스 작업 중 문제가 발생하였습니다. 관리자에게 문의하세요.");
		} finally {
			MySqlConnectionProvider.closeStatement(stmt);
		}
	}

	public int[] batchAdd(List<Person> list) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = MySqlConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO person (name, age) VALUES (?, ?)";

			stmt = conn.prepareStatement(sql);

			for (Person p : list) {
				stmt.setString(1, p.getName());
				stmt.setInt(2, p.getAge());
				stmt.addBatch();
			}

			int[] result = stmt.executeBatch();
			conn.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();

				}

			}
		}

		return null;

	}

	@Override
	public List<Person> getAll() {
		List<Person> list = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = MySqlConnectionProvider.getConnection();

			String query = "SELECT * FROM person";
			System.out.println("SQL 명령 확인: " + query);

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터 베이스 작업 중 문제가 발생하였습니다. 관리자에게 문의하세요.");
		} finally {
			MySqlConnectionProvider.closeResultSet(rs);
			MySqlConnectionProvider.closeStatement(stmt);
			MySqlConnectionProvider.closeConnection(conn);
		}

		return list;
	}
}
