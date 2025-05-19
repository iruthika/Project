// VolunteerService.java
package com.example.lbfds.service;

import com.example.lbfds.dto.HistoryDTO;

import com.example.lbfds.model.Volunteer;

import com.example.lbfds.repo.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepo volunteerRepo;

    public Volunteer addVolunteerData(Volunteer volunteer) {
        return volunteerRepo.save(volunteer);
    }

    public List<Volunteer> getVolunteerHistory(Long myId) {
        return volunteerRepo.findByMyId(myId);
    }
    public List<HistoryDTO> volunteerhistory(Long myid){
    	return volunteerRepo.findVolunteerByUserId(myid);
    }

	public List<Volunteer> findall() {
		// TODO Auto-generated method stub
		return volunteerRepo.findAll();
	}
 
}
