package com.JavaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JavaSpring.entity.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
  
}
