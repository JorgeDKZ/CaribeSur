package com.caribe.sur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caribe.sur.model.Plane;
import com.caribe.sur.repository.PlanesRepository;

@Service
public class PlaneGestions {

    @Autowired
    private PlanesRepository planesRepository;

    public void saveUser(Plane Plane) {
        planesRepository.save(Plane);
    }

    public Plane findUserById(Long id) {
        return planesRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        planesRepository.deleteById(id);
    }

    public List<Plane> getAllUsers() {
        return planesRepository.findAll();
    }

}
