package com.example.lbfds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String email;
private String Username;
private Long ContactNo;
private String Address;
private String Role;
private String password;


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
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
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}

public User(Long id, String email, String username, Long contactNo, String address, String role, String password) {
	super();
	this.id = id;
	this.email = email;
	Username = username;
	ContactNo = contactNo;
	Address = address;
	Role = role;

	this.password = password;
}
public User() {
	
}

}
