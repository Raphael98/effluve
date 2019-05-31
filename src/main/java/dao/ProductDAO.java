package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import entity.Gender;
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
				product.setDescription(rs.getString("description"));
				product.setPrice(Double.parseDouble(rs.getString("price")));
				product.setBrand(new BrandDAO().get(Integer.parseInt(rs.getString("brand_id"))));
				product.setGender(new GenderDAO().get(Integer.parseInt(rs.getString("gender_id"))));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	public Product get(int id) {
		String sql = String.format("SELECT * FROM %s WHERE id = ?", this.table);
		Product product = new Product();
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(Double.parseDouble(rs.getString("price")));
			product.setBrand(new BrandDAO().get(Integer.parseInt(rs.getString("brand_id"))));
			product.setGender(new GenderDAO().get(Integer.parseInt(rs.getString("gender_id"))));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	public void delete(int id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Product product) {
		String sql = String.format("UPDATE %s set name = ?, price = ?, brand_id = ?, description = ?, gender_id = ? where id = ?;", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getBrand().getId());
			stmt.setString(4, product.getDescription());
			stmt.setInt(5, product.getGender().getId());
			stmt.setInt(6, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getByName(String name) {
		List<Product> products = new ArrayList<>();
		String sql = String.format("SELECT * FROM %s;", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(Double.parseDouble(rs.getString("price")));
				product.setBrand(new BrandDAO().get(Integer.parseInt(rs.getString("brand_id"))));
				product.setGender(new GenderDAO().get(Integer.parseInt(rs.getString("gender_id"))));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> search(String[] genders, String[] brands) {
		String sql = String.format("SELECT * FROM %s ", this.table);
		if(genders != null) {
			String[] genderField = new String[genders.length];
			for(int i = 0; i < genders.length; i++) {
				genderField[i] = "gender_id = ?";
			}
			sql += "WHERE "+String.join(" OR ", genderField);
		}
		
		if(brands != null) {
			String[] brandField = new String[brands.length];
			for(int i = 0; i < brands.length; i++) {
				brandField[i] = "brand_id = ?";
			}
			sql += genders == null ? "WHERE " : "";
			sql += String.join(" OR ", brandField);
		}
		List<Product> products = new ArrayList<>();
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			if(genders != null) {
				for(int i = 0; i < genders.length; i++){
					stmt.setInt(i+1, Integer.parseInt(genders[i]));
				}
			}
			if(brands != null) {
				int x = genders == null ? 1 : genders.length + 1;
				for( int i = 0; i < brands.length; i++){
					stmt.setInt(x, Integer.parseInt(brands[i]));
					x += 1;
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(Double.parseDouble(rs.getString("price")));
				product.setBrand(new BrandDAO().get(Integer.parseInt(rs.getString("brand_id"))));
				product.setGender(new GenderDAO().get(Integer.parseInt(rs.getString("gender_id"))));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
