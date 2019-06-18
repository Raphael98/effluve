package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CosNaming.NamingContextPackage.NotFound;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User get(int id) throws NotFound {
		User user = new User();
		String sql = String.format("SELECT * FROM %s where id = %s", this.table, id);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				throw new NotFound();
			}
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setCep(rs.getString("cep"));
			user.setEmail(rs.getString("name"));
			user.setAdmin(rs.getBoolean("admin"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return user;
	}
	
	public User login(User user) {
		String sql = String.format("SELECT * FROM %s WHERE email = ? and password = ?", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
