package com.example.lbfds.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lbfds.model.SoftDelete;
import com.example.lbfds.repo.softDeleteRepo;
import com.example.lbfds.service.SoftDeleteService;
@RequestMapping("/softdelete")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
 public class SoftDeleteController {
	 @Autowired
	 SoftDeleteService softDeleteService;
	 @Autowired
	 softDeleteRepo softdelete;

	
	@GetMapping("/viewDeletedUsers")
	public ResponseEntity<List<SoftDelete>> send() {
		List<SoftDelete> deletedUsers=softdelete.findAll();
		if(deletedUsers.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}
		else
		{
			return ResponseEntity.ok(deletedUsers);
		}
	}
	

	@PostMapping("/restore/{id}")
	public ResponseEntity<String> restoreDeletedUser(@PathVariable Long id) {
	   softDeleteService.restore(id);
	   return ResponseEntity.ok().build();
	}
	
	
	
	
	
}
