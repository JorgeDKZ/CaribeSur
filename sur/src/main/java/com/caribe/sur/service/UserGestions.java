package com.caribe.sur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caribe.sur.model.User;
import com.caribe.sur.repository.UsersRepository;

@Service
public class UserGestions {

    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(User user) {
        usersRepository.save(user);
    }

    public User findUserById(String id) {
        return usersRepository.findById(id).orElse(null);
    }
    
    public void deleteUser(String id) {
        usersRepository.deleteById(id);
    } 

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

}
