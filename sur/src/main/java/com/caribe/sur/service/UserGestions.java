package com.caribe.sur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caribe.sur.model.User;
import com.caribe.sur.repository.UsersRepository;

@Service
public class UserGestions {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UserGestions(UsersRepository usersRepository,PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


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
