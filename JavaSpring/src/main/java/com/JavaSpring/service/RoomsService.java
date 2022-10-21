package com.JavaSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.JavaSpring.entity.Rooms;
import com.JavaSpring.exception.EntityNotFoundException;
import com.JavaSpring.repository.RoomsRepository;

@Service
public class RoomsService {

	@Autowired
	private RoomsRepository roomsRepo;

	public Rooms fetchById(final Long id) {
		Optional<Rooms> rooms = roomsRepo.findById(id);
		if (!rooms.isPresent()) {
			throw new EntityNotFoundException("id-" + id);
		}
		return rooms.get();
	}

	public List<Rooms> fetchAll() {
		return roomsRepo.findAll();
	}

	public Rooms create(final Rooms rooms) {
		return roomsRepo.save(rooms);
	}

	public ResponseEntity<Object> update(final Rooms rooms, final Long id) {
		Optional<Rooms> roomsOptional = roomsRepo.findById(id);
		if (!roomsOptional.isPresent()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			throw new EntityNotFoundException("id-" + id);
		}
		rooms.setId(id);
		roomsRepo.save(rooms);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	public void delete(final Long id) {
		roomsRepo.deleteById(id);
	}

}
