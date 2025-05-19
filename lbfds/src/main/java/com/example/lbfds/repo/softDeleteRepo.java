package com.example.lbfds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lbfds.model.SoftDelete;
@Repository
public interface softDeleteRepo extends JpaRepository<SoftDelete, Long> {

}
