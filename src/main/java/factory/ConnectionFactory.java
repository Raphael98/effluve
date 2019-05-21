package factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {
	
	public static Map<String,String> getCredentials(){
		File credentialsFile = new File("credentials");
		Map<String, String> credentials = new HashMap<>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(credentialsFile));
			String login = bf.readLine().split("=")[1];
			String password = bf.readLine().split("=")[1];
			credentials.put("login", login);
			credentials.put("password", password);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return credentials;
	}
	
	public Connection getConnection() {
		Map<String,String> credentials = ConnectionFactory.getCredentials();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/effluve", credentials.get("login"), credentials.get("password"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		Map<String, String> c = ConnectionFactory.getCredentials();
	}
}
