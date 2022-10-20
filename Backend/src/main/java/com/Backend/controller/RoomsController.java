package com.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.entity.Rooms;
import com.Backend.service.RoomsService;

@RestController
public class RoomsController {

	@Autowired
	private RoomsService roomsService;

	@GetMapping("/rooms")
	public List<Rooms> fetchAll() {
		return this.roomsService.fetchAll();
	}

	@GetMapping("/rooms/{id}")
	public Rooms fetchById(@PathVariable String id) {
		return this.roomsService.fetchById(id);
	}

	@DeleteMapping("/rooms/{id}")
	public void delete(@PathVariable String id) {
		this.roomsService.delete(id);
	}

	@PostMapping("/rooms")
	public Rooms create(@RequestBody Rooms rooms) {
		return this.roomsService.create(rooms);
	}
	
	@PutMapping("/rooms/{id}")
	public ResponseEntity<Object> update(@RequestBody Rooms rooms, @PathVariable String id) {
		return this.roomsService.update(rooms, id);
	}
}