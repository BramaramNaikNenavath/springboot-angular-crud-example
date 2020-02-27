package com.tek.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tek.models.Users;

@Repository
public interface LoginRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByName(String username);
}
