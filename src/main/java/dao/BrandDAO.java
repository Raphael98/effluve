package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import entity.Brand;
import entity.Product;

public class BrandDAO extends DAO {
	public String table = "brands";
	
	public void add(Brand brand) {
		String sql = String.format("INSERT INTO %s (name, description) values (?,?)", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, brand.getName());
			stmt.setString(2, brand.getDescription());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Brand get(int id) throws NotFound {
		Brand brand = new Brand();
		String sql = String.format("SELECT * FROM %s where id = %s", this.table, id);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				throw new NotFound();
			}
			brand.setId(rs.getInt("id"));
			brand.setName(rs.getString("name"));
			brand.setDescription(rs.getString("Description"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return brand;
	}
	
	public List<Brand> getAll() {
		List<Brand> brands = new ArrayList<>();
		String sql = String.format("SELECT * FROM %s;", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
				brand.setDescription(rs.getString("Description"));
				brands.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return brands;
	}
	
	public void delete(Brand brand) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, brand.getId());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Brand brand) {
		String sql = String.format("UPDATE %s set name = ?, description = ? where id = ?;", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, brand.getName());
			stmt.setString(2, brand.getDescription());
			stmt.setInt(3, brand.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
