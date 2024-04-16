package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements ConnectionInterface{
	
	private Connection conn;
	private String url;
	private String user;
	private String password;
	
	public MySQLConnector() {
		url = "jdbc:mysql://127.0.0.1:3306/db_projeto";
		user = "root";
		password = "password";
	};
	
	public MySQLConnector(String url,String user,String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
		try {
			if(conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void setConnection(Connection connection) {
		conn = connection;
	}
	
	public void closeConnection() throws SQLException {
		if(conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
