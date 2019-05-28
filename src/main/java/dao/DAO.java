package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Entity;
import entity.User;
import factory.ConnectionFactory;

public abstract class DAO {
	protected String table;
	protected Connection conn;
	
	public DAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void add(Entity entity) {
		String sql = String.format("INSERT INTO %s (name, email, password, cep, number) VALUES (?, ?, ?, ?, ?)", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, "");
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
