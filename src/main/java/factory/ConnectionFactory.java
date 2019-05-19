package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/effluve", "root", "tsuki.1");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
