package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Entity;
import entity.User;

public class UserDAO extends DAO{
	private String table = "users";
	
	public void add(User user) {
		String sql = String.format("INSERT INTO %s (name, email, password, cep, number) VALUES (?, ?, ?, ?, ?)", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getCep());
			stmt.setString(5, user.getNumber());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
