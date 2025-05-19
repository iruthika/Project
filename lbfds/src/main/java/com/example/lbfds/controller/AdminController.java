package com.example.lbfds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lbfds.dto.RegisterRequest;
import com.example.lbfds.model.Donor;
import com.example.lbfds.model.User;
import com.example.lbfds.model.Volunteer;
import com.example.lbfds.service.DonorService;
import com.example.lbfds.service.UserService;
import com.example.lbfds.service.VolunteerService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	VolunteerService volunteerService;
	
	@Autowired
	DonorService donorService;
	
	@GetMapping("viewallusers")
		public List<User> viewallusers(){
		return  userService.findAll();
		}
	
	@GetMapping("viewallpickup")
		public List<Volunteer> viewallpickup(){
			return volunteerService.findall();
		}
	  @GetMapping("viewalldonation")
	  public List<Donor> viewalldonation(){
		  return donorService.findall();
	  }
	  
	  @PutMapping("edituser/{userId}")
	  public User edituser(@PathVariable Long userId,@RequestBody RegisterRequest r) {
		  User u = userService.findByid(userId);
		  u.setAddress(r.getAddress());
		  u.setUsername(r.getUsername());
		  u.setContactNo(r.getContactNo());
		  u.setEmail(r.getEmail());
		  userService.save(u);
		  return u;
		  
	  }
	  
	  
	  
	  @DeleteMapping("/deleteuser/{id}")
	    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
	        try {
	            userService.deleteUserById(id);
	            return ResponseEntity.ok().build();
	        } catch (Exception e) {
	            return ResponseEntity.noContent().build();
	        }
	    }
	  
	 
	  
	}
	





