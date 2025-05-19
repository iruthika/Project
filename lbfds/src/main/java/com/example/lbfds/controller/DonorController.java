package com.example.lbfds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lbfds.dto.HistoryDTO;
import com.example.lbfds.dto.VolunteerDTO;
import com.example.lbfds.model.Donor;
import com.example.lbfds.repo.DonorRepo;
import com.example.lbfds.service.DonorService;

@RestController
@RequestMapping("/donation")
@CrossOrigin(origins="http://localhost:4200")
public class DonorController {
	
	@Autowired
	DonorService donorService;
	
	@Autowired
	DonorRepo donorRepo;
	
	@PostMapping("/DonateFood")
	public ResponseEntity<Donor> getDonation(@RequestBody Donor donor) {
	    donorService.getDonationDetail(donor);
	    return new ResponseEntity<>(donor, HttpStatus.CREATED);
	}

	
	 @GetMapping("/search/{location}")
	    public ResponseEntity<List<Donor>> getFoodDonation(@PathVariable String location) {
	        List<Donor> availableDonation = donorService.searchFoodByLocation(location);
	        
	        if (availableDonation.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        
	        return ResponseEntity.ok(availableDonation);  
	    }
	 
	 @PatchMapping("/updateStatus/{id}")
	 public ResponseEntity<Map<String, Object>> updateDonationStatus(@PathVariable Long id, @RequestParam String status) {
	     boolean updated = donorService.updateDonationStatus(id, status);
	     Map<String, Object> response = new HashMap<>();
	     if (updated) {
	         response.put("message", "Status updated successfully.");
	         response.put("success", true);
	         return ResponseEntity.ok(response);
	     } else {
	         response.put("message", "Donation not found with ID: " + id);
	         response.put("success", false);
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	     }
	 }

	 
	 @GetMapping("/history/{myId}")
	    public List<HistoryDTO> getHistory(@PathVariable Long myId) {
	        return donorService.getHistory(myId);
	    }
	 
	}
