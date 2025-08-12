package com.caribe.sur.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caribe.sur.enumerators.Role;
import com.caribe.sur.model.User;
import com.caribe.sur.repository.UsersRepository;

@Service
public class UserGestions implements UserDetailsService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    private static final String FIRST_USER_ID = "admin";
    private static final String FIRST_USER_PASSWORD = "admin123";

    public UserGestions(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;

        User firstUser = new User(FIRST_USER_ID, FIRST_USER_PASSWORD, Role.ADMIN.name());
        saveAdmin(firstUser);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER.name());
        usersRepository.save(user);
    }

    
    public boolean changePassword(String userId,String oldPassword ,String newPassword) {
        User user = findUserById(userId);
        if (user != null && passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            usersRepository.save(user);
            return true;
        }
        return false;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserById(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

}
