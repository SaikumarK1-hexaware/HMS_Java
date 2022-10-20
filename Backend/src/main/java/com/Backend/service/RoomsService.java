package com.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Backend.entity.Rooms;
import com.Backend.exception.EntityNotFoundException;
import com.Backend.repository.RoomsRepository;

@Service  
public class RoomsService {

  @Autowired
  private RoomsRepository roomsRepo;

  public List<Rooms> fetchAll() {
    return roomsRepo.findAll();
  }

  public Rooms fetchById(final String id) {
    Optional<Rooms> rooms = roomsRepo.findById(id);

		if (!rooms.isPresent()){
			throw new EntityNotFoundException("id-" + id);
    }
		return rooms.get();
  }

  public void delete(final String id) {
    roomsRepo.deleteById(id);
  }

  public Rooms create(final Rooms rooms) {
    return roomsRepo.save(rooms);
  }

  public ResponseEntity<Object> update(final Rooms rooms, final String id) {
    Optional<Rooms> roomsOptional = roomsRepo.findById(id);
		if (!roomsOptional.isPresent()) {
			return ResponseEntity.notFound().build();
    }
		rooms.setId(id);
		roomsRepo.save(rooms);
		return ResponseEntity.noContent().build();
  }

}
