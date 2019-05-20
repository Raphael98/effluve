package dao;

import java.sql.Connection;

import bean.Bean;
import factory.ConnectionFactory;

public abstract class DAO {
	
	protected Connection conn;
	
	public DAO() {
		conn = new ConnectionFactory().getConnection();
	}
}
