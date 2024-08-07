package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String username);

}
