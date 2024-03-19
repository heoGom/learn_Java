package app12.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyWebContextListener implements ServletContextListener {

	private static DataSource dataSource;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/my_db");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("root");
		
		dataSource=ds;
		
	}
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	

}
