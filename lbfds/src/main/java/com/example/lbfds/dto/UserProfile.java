package com.example.lbfds.dto;

public class UserProfile {
    
    private String Username;
    private String email;
    private Long ContactNo;
    private String Address;
    
    
	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getContactNo() {
		return ContactNo;
	}


	public void setContactNo(Long contactNo) {
		ContactNo = contactNo;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public UserProfile(String username, String email, Long contactNo, String address) {
		super();
		Username = username;
		this.email = email;
		ContactNo = contactNo;
		Address = address;
	}
    
	public UserProfile() {
		
	}
    

}
