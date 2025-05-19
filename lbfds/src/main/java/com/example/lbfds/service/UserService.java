package com.example.lbfds.service;

import java.util.List;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lbfds.dto.LoginRequest;
import com.example.lbfds.dto.RegisterRequest;
import com.example.lbfds.dto.UserProfile;
import com.example.lbfds.model.SoftDelete;
import com.example.lbfds.model.User;
import com.example.lbfds.repo.UserRepo;
import com.example.lbfds.repo.softDeleteRepo;

@Service
public class UserService {
	
@Autowired
private UserRepo userRepo;

@Autowired
private softDeleteRepo softdeleteRepo;

@Autowired
private BCryptPasswordEncoder passwordEncoder;



public User loginUser(LoginRequest request) {
    User user = userRepo.findByEmail(request.email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.password, user.getPassword())) {
        throw new RuntimeException("Invalid password");
    }

    return user;
}


public User registerUser(RegisterRequest request) {
    User user = new User();
    user.setEmail(request.email);
    user.setUsername(request.username);
    user.setContactNo(request.contactNo);
    user.setAddress(request.address);
    user.setRole(request.role);
    user.setPassword(passwordEncoder.encode(request.password));

    return userRepo.save(user);
}



public UserProfile getUserProfile(Long userId) {
    User user = userRepo.findById(userId).orElse(null);
    if (user == null) {
        return null;
    }
    return new UserProfile(user.getUsername(), user.getEmail(), user.getContactNo(), user.getAddress());
}


public Long getUserid(String email) {
	
	// TODO Auto-generated method stub
	User s = userRepo.findByEmail(email).get();
	return s.getId();
}


public User updateUserDetails(Long id, User updatedUser) {
    Optional<User> existingUserOpt = userRepo.findById(id);

    if (existingUserOpt.isPresent()) {
        User existingUser = existingUserOpt.get();

        // Update the contact number if provided
        if (updatedUser.getContactNo() != null) {
            existingUser.setContactNo(updatedUser.getContactNo());
        }

        // Update the address if provided
        if (updatedUser.getAddress() != null && !updatedUser.getAddress().isEmpty()) {
            existingUser.setAddress(updatedUser.getAddress());
        }

        // Save the updated user object
        return userRepo.save(existingUser);
    } else {
        return null; // User not found
    }
}

public List<User> findAll() {
	// TODO Auto-generated method stub
	return userRepo.findAll();
}

public User findByid(Long userId) {
	// TODO Auto-generated method stub
	return  userRepo.findById(userId).get();
	

}

public void save(User u) {
	// TODO Auto-generated method stub
	userRepo.save(u);
}

public void deleteUserById(Long id) {
	User s = userRepo.findById(id).get();
	SoftDelete d = new SoftDelete();
	d.setAddress(s.getAddress());
	d.setContactNo(s.getContactNo());
	d.setUsername(s.getUsername());
	d.setEmail(s.getEmail());
	d.setRole(s.getRole());
	d.setPassword(s.getPassword());
	softdeleteRepo.save(d);
	
    userRepo.deleteById(id);
}



}

