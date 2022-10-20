package com.Backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Backend.entity.Rooms;

@Repository
public interface RoomsRepository extends MongoRepository<Rooms, String> {
  
}