package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Brand;

public class BrandDAO extends DAO {
	public String table = "brands";
	
	public Brand get(int id) {
		String sql = String.format("SELECT * FROM %s; where id = %i", this.table, id);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return new Brand(rs.getString("name"), rs.getString("description"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
