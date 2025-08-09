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

    public UserGestions(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER.name()); // Default role, can be changed later
        usersRepository.save(user);
    }

    public boolean isLogin(User user) {
        User userExist = findUserById(user.getUserName());
        if (userExist != null) {
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
