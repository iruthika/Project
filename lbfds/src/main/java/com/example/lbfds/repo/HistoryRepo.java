package com.example.lbfds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lbfds.dto.HistoryDTO;
import com.example.lbfds.model.Donor;

@Repository
public interface HistoryRepo extends JpaRepository<Donor, Long> {

	 @Query("SELECT new com.example.lbfds.dto.HistoryDTO( d.foodAvailable, u.id,u.Address, d.Date, d.pickupTime, d.location) " +
	           "FROM Donor d JOIN User u ON d.myid = u.id " +
	           "WHERE u.id = :myId")
    List<HistoryDTO> findHistoryByUserId(@Param("myId") Long myId);
}
