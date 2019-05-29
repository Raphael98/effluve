package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import entity.Brand;
import entity.Gender;

public class GenderDAO extends DAO{
	private String table = "genders";
	
	public List<Gender> getAll() {
		List<Gender> genders = new ArrayList<>();
		String sql = String.format("SELECT * FROM %s;", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Gender gender = new Gender();
				gender.setId(rs.getInt("id"));
				gender.setName(rs.getString("name"));
				genders.add(gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genders;
	}
	
	public Gender get(int id) throws NotFound {
		Gender gender = new Gender();
		String sql = String.format("SELECT * FROM %s where id = %s", this.table, id);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				throw new NotFound();
			}
			gender.setId(rs.getInt("id"));
			gender.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gender;
	}
}
