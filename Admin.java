package main;

public class Admin extends Customer{

	private String id = "Admin";
	private String password = "Admin123";
	
	public Admin(String name, String phone) {
		super(name, phone);
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
}
