package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Order;

public class OrderDAO extends DAO {
	protected String table = "orders";
	
	public void add(Order order) {
		String sql = String.format("INSERT INTO %s (code, date_purchase, product_id, user_id) VALUES (?,?,?,?)", this.table);
		try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
			stmt.setString(1, order.getCode());
			stmt.setDate(2, order.getDate());
			stmt.setInt(3, order.getProduct().getId());
			stmt.setInt(4, order.getUser().getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> getAll(int id) {
		List<Order> orders = new ArrayList<>();
		String sql = String.format("SELECT * FROM %s WHERE user_id = ?", this.table);
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setCode(rs.getString("code"));
				order.setDate(rs.getDate("date_purchase"));
				order.setProduct(new ProductDAO().get(rs.getInt("product_id")));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
