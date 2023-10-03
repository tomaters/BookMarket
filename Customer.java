package main;

public class Customer {

	private String  name;
	private String phone;
	private String address;
	
	public Customer() {}
	
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public Customer(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
