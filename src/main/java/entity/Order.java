package entity;

import java.sql.Date;
import java.util.Random;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import dao.ProductDAO;
import dao.UserDAO;

public class Order extends Entity{
	private String code;
	private Date date;
	private User user;
	private Product product;
	
	public Order() {}
	
	public Order(String user, String product) {
		this.code = this.generateCode();
		this.date = new Date(new java.util.Date().getTime());
		try {
			this.user = new UserDAO().get(Integer.parseInt(user));
			this.product = new ProductDAO().get(Integer.parseInt(product));
		} catch (NumberFormatException | NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String generateCode() {
		Random rand = new Random();
		String code = "";
		int n;
		for(int i = 0; i < 5; i++) {
			n = rand.nextInt(50);
			code += Integer.toString(n);
		}
		return code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
