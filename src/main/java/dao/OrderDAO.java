package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Order;

public class OrderDAO extends DAO {
	protected String tabel = "orders";
	
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
}
