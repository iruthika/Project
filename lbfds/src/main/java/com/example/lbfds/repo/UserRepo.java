package com.example.lbfds.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lbfds.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
