package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Product;

public class ProductDAO extends DAO {
	private String table = "products";
	
	public void add(Product product) {
		String sql = String.format("INSERT INTO %s (name, price, brand_id, description) VALUES (?,?,?,?)", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getBrand().getId());
			stmt.setString(4, product.getDescription());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
