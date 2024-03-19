package jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionProvider {

	private static DataSource datasource;

	static {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/guestbook");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("root");

		datasource = ds;

	}

	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

}
