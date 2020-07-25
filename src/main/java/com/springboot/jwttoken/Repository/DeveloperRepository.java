package com.springboot.jwttoken.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.jwttoken.Entities.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
	Developer findByUsername(String username);
}
