package com.caribe.sur.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caribe.sur.model.DTO.User;

public interface UsersRepository extends JpaRepository<User, Long>{

}
