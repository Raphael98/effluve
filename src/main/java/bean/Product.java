package bean;

public class Product extends Bean {
	private String name;
	private double price;
	private Brand brand;
	private String description;
	
	public Product() {}
	
	public Product(String name, double price, Brand brand, String description) {
		this.name = name;
		this.price = price;
		this.brand = brand;
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
}
