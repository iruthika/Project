package com.example.lbfds.dto;


import java.time.LocalTime;

public class HistoryDTO {
	private Long myId;
private String foodAvailable;

private String Address;
private String Date;
private LocalTime pickupTime;
private String location;

public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getFoodAvailable() {
	return foodAvailable;
}
public void setFoodAvailable(String foodAvailable) {
	this.foodAvailable = foodAvailable;
}
public Long getMyId() {
	return myId;
}
public void setMyId(Long myId) {
	this.myId = myId;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public LocalTime getPickupTime() {
	return pickupTime;
}
public void setPickupTime(LocalTime pickupTime) {
	this.pickupTime = pickupTime;
}
public HistoryDTO(String foodAvailable, Long myId, String address, String date, LocalTime pickupTime, String location) {
	super();
	this.foodAvailable = foodAvailable;
	this.myId = myId;
	Address = address;
	Date = date;
	this.pickupTime = pickupTime;
	this.location=location;
}
public HistoryDTO() {
	
}
}
