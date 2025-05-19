package com.example.lbfds.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lbfds.model.SoftDelete;
import com.example.lbfds.model.User;
import com.example.lbfds.repo.softDeleteRepo;
import com.example.lbfds.repo.UserRepo;
@Service
public class SoftDeleteService {
	@Autowired
	private softDeleteRepo softdeleterepo;

	@Autowired
	private UserRepo userRepo;
	
	
	public String restore(Long id) {
		Optional<SoftDelete> softDeleteUser=softdeleterepo.findById(id);
		
		
		if(softDeleteUser.isPresent()) {
			SoftDelete s=softDeleteUser.get();
			
			User d=new User();
			d.setAddress(s.getAddress());
			d.setContactNo(s.getContactNo());
			d.setUsername(s.getUsername());
			d.setEmail(s.getEmail());
			d.setRole(s.getRole());
			d.setPassword(s.getPassword());
			
			userRepo.save(d);
			softdeleterepo.deleteById(id);
			
			return "User restored";
		}
		return "User not restoresd";
	}

}
