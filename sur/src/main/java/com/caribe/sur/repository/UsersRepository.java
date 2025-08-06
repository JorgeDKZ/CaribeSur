package com.caribe.sur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caribe.sur.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, String>{

}
