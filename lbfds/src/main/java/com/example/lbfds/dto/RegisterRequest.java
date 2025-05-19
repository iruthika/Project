package com.example.lbfds.dto;

public class RegisterRequest {
	
	public String email;
    public String username;
    public Long contactNo;
	public String address;
    public String role;
    public String password;
    
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
    public RegisterRequest(String email, String username, Long contactNo, String address, String role,
			String password) {
		super();
		this.email = email;
		this.username = username;
		this.contactNo = contactNo;
		this.address = address;
		this.role = role;
		this.password = password;
	}

}
