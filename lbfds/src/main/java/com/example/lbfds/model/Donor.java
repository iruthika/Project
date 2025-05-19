package com.example.lbfds.model;


import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donor")
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "food_available")
	private String foodAvailable;

	@Column(name = "no_of_servings")
	@JsonProperty("no_of_servings")
	private Integer noOfServings;

	@Column(name = "pickup_time")
	private LocalTime pickupTime;

	@Column(name = "location")
	private String location;

	@Column(name = "status")
	private String status;
	@Column(name = "Date")
	private String Date;
	private Long myid;
	public Long getMyid() {
		return myid;
	}

	public void setMyid(Long myid) {
		this.myid = myid;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodAvailable() {
		return foodAvailable;
	}

	public void setFoodAvailable(String foodAvailable) {
		this.foodAvailable = foodAvailable;
	}

	public Integer getNoOfServings() {
		return noOfServings;
	}

	public void setNoOfServings(Integer noOfServings) {
		this.noOfServings = noOfServings;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Donor(Long id, String foodAvailable, Integer noOfServings, LocalTime pickupTime, String location,
			String status,String Date,Long myid) {
		super();
		this.id = id;
		this.foodAvailable = foodAvailable;
		this.noOfServings = noOfServings;
		this.pickupTime = pickupTime;
		this.location = location;
		this.status = status;
		this.Date=Date;
		this.myid = myid;
	}

	public Donor() {
	}
}
