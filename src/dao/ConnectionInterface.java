package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionInterface {
	Connection getConnection() throws SQLException;
	void closeConnection() throws SQLException;
}
