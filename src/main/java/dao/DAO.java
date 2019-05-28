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
}
