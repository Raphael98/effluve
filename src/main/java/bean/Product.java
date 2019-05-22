package bean;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import dao.BrandDAO;
import dao.GenderDAO;

public class Product extends Bean {
	private String name;
	private double price;
	private Brand brand;
	private String description;
	private Gender gender;
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Product() {}

	public Product(String name, double price, Brand brand, String description, Gender gender) {
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.description = description;
	}
	
	public Product(String name, String price, String brand, String description, String gender) {
		this.name = name;
		this.price = Integer.parseInt(price);
		try {
			this.brand = new BrandDAO().get(Integer.parseInt(brand));
			this.gender = new GenderDAO().get(Integer.parseInt(gender));
		} catch (NotFound e) {
			e.printStackTrace();
		}
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static void main(String[] args) {
		System.out.println(String.format("Este é o número %s", 2));
	}
}
