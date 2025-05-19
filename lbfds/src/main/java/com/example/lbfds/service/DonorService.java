package com.example.lbfds.service;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lbfds.dto.HistoryDTO;
import com.example.lbfds.dto.VolunteerDTO;
import com.example.lbfds.model.Donor;
import com.example.lbfds.repo.DonorRepo;
import com.example.lbfds.repo.HistoryRepo;

import jakarta.transaction.Transactional;

@Service
public class DonorService {

	@Autowired
	DonorRepo donorRepo;
	
	@Autowired
	HistoryRepo historyRepo;
	
	
    public void getDonationDetail(Donor donor){
        donorRepo.save(donor);
    }

    public List<Donor> searchFoodByLocation(String location){
        return donorRepo.findByLocationContainingIgnoreCase(location);
    }
    @Transactional
    public boolean updateDonationStatus(Long id, String status) {
        Optional<Donor> donorOpt = donorRepo.findById(id);
        if (donorOpt.isPresent()) {
            Donor donor = donorOpt.get();
            donor.setStatus(status);
            donorRepo.save(donor); 
            return true; 
        }
        return false;
    }
    
    public List<HistoryDTO> getHistory(Long myId) {
        return historyRepo.findHistoryByUserId(myId);
    }

	public List<Donor> findall() {
		// TODO Auto-generated method stub
		return donorRepo.findAll();
	}
    
//	public List<VolunteerDTO> getVolunteerHistory(Long myId) {
//		return volunteerRepo.findVolunteerHistoryByUserId(myId);
//	}
}
