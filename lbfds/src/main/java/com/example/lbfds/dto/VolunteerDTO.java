package com.example.lbfds.dto;

import java.time.LocalTime;

public class VolunteerDTO {
	
	private Long myId;
	private String foodAvailable;
	private String Date;
	private LocalTime pickupTime;
	private String location;

	public Long getMyId() {
		return myId;
	}

	public void setMyId(Long myId) {
		this.myId = myId;
	}

	public String getFoodAvailable() {
		return foodAvailable;
	}

	public void setFoodAvailable(String foodAvailable) {
		this.foodAvailable = foodAvailable;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public VolunteerDTO(Long myId, String foodAvailable, String date, LocalTime pickupTime, String location) {
		super();
		this.myId = myId;
		this.foodAvailable = foodAvailable;
		Date = date;
		this.pickupTime = pickupTime;
		this.location = location;
	}

}
