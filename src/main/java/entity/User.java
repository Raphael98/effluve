
package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class User extends Entity {
	private String name;
	private String password;
	private String email;
	private String cep;
	private String number;
	private boolean admin;
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public User() {}
	
	public User(String email, String name, String password, String cep, String number) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.cep = cep;
		this.number = number;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstName() {
		return name.split(" ")[0]; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
