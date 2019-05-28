package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;
import entity.Product;

public class ProductDAO extends DAO {
	private String table = "products";
	
	public void add(Product product) {
		String sql = String.format("INSERT INTO %s (name, price, brand_id, description, gender_id) VALUES (?,?,?,?,?)", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getBrand().getId());
			stmt.setString(4, product.getDescription());
			stmt.setInt(5, product.getGender().getId());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		String sql = String.format("SELECT * FROM %s;", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("Description"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
}
