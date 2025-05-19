// Volunteer.java (Entity)
package com.example.lbfds.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long myId;
    private String foodAvailable;
    private String date;
    private LocalTime pickupTime;
    private String location;

    public Volunteer() {}

    public Volunteer(Long myId, String foodAvailable, String date, LocalTime pickupTime, String location) {
        this.myId = myId;
        this.foodAvailable = foodAvailable;
        this.date = date;
        this.pickupTime = pickupTime;
        this.location = location;
    }

    // Getters and setters
    public Long getId() { return id; }

    public Long getMyId() { return myId; }
    public void setMyId(Long myId) { this.myId = myId; }

    public String getFoodAvailable() { return foodAvailable; }
    public void setFoodAvailable(String foodAvailable) { this.foodAvailable = foodAvailable; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public LocalTime getPickupTime() { return pickupTime; }
    public void setPickupTime(LocalTime pickupTime) { this.pickupTime = pickupTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
