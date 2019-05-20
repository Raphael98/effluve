package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO extends DAO{
	private String table = "user";
	
	public void add(String name, String email, String password) {
		String sql = String.format("INSERT INTO %s (name, email, password) VALUES (?, ?, ?)", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2, name);
			stmt.setString(3, name);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
