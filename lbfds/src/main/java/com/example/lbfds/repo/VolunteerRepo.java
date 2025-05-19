package com.example.lbfds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lbfds.dto.HistoryDTO;
import com.example.lbfds.dto.VolunteerDTO;
import com.example.lbfds.model.Donor;
import com.example.lbfds.model.Volunteer;


public interface VolunteerRepo extends JpaRepository<Volunteer, Long> {
	@Query("SELECT new com.example.lbfds.dto.HistoryDTO( d.foodAvailable, u.id,u.Address, d.date, d.pickupTime, d.location) " +
	           "FROM Volunteer d JOIN User u ON d.myId = u.id " +
	           "WHERE u.id = :myId")
 List<HistoryDTO> findVolunteerByUserId(@Param("myId") Long myId);
 List<Volunteer> findByMyId(Long myId);
 
 
 
}
