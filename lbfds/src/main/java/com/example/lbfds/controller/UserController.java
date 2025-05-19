package com.example.lbfds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lbfds.dto.LoginRequest;
import com.example.lbfds.dto.RegisterRequest;
import com.example.lbfds.dto.UserProfile;
import com.example.lbfds.model.User;
import com.example.lbfds.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User createdUser = userService.registerUser(request);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
	
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
            User user = userService.loginUser(request);
            return ResponseEntity.ok(user);
    }
	
	
	
	@GetMapping("/getUserid/{email}")
		public Long getUserid(@PathVariable String email) {
			return userService.getUserid(email);
		}
	
	
	 @GetMapping("/{id}/profile")
	    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
	        UserProfile userProfile = userService.getUserProfile(id);
	        return ResponseEntity.ok(userProfile);
	    }
	 
	 
	 @PatchMapping("/update/{id}")
	 public ResponseEntity<User> updateUserDetails(@PathVariable Long id, @RequestBody User updatedUser) {
	     User user = userService.updateUserDetails(id, updatedUser);
	     
	     if (user != null) {
	         return ResponseEntity.ok(user);
	     } else {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	     }
	 }
	 
	 
}

