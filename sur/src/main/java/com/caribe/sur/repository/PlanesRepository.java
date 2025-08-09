package com.caribe.sur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caribe.sur.model.Plane;

@Repository
public interface PlanesRepository extends JpaRepository<Plane, Long> {

}
