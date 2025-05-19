package com.example.lbfds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lbfds.dto.HistoryDTO;
import com.example.lbfds.model.Donor;
@Repository
public interface DonorRepo extends JpaRepository<Donor, Long> {

	List<Donor> findByLocationContainingIgnoreCase(String location);

	
}
