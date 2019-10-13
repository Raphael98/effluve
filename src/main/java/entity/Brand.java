package entity;

public class Brand extends Entity{
	protected String table = "brands";
	private String name;

	public Brand() {}
	
	public Brand(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
