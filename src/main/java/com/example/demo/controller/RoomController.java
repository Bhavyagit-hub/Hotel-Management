package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController // is controller which provides different end points to access the services
@RequestMapping("/api/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;

	/*
	 * public RoomController(RoomService roomService) { super(); this.roomService =
	 * roomService;
	 * 
	 * }
	 */

//to add room to hotels
	@PostMapping("{hotelId}")
	public ResponseEntity<Room> addRooms(@Valid @RequestBody Room room, @PathVariable long hotelId) {

		return new ResponseEntity<Room>(roomService.addRoom(room, hotelId), HttpStatus.CREATED);
	}

	// to get all rooms
	@GetMapping("{hotelId}")
	public List<Room> getAllRooms(@PathVariable long hotelId) {
		return roomService.getAllRooms(hotelId);
	}

	// to get room by room id
	@GetMapping("rooms/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") long roomID) {
		return new ResponseEntity<Room>(roomService.getRoomById(roomID), HttpStatus.OK);
	}

	// to update room
	@PutMapping("{id}")
	public ResponseEntity<Room> updateRoom(@Valid @PathVariable("id") long id, @RequestBody Room room) {
		return new ResponseEntity<Room>(roomService.updateRoom(room, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteRoom(@PathVariable("id") long id) {
		roomService.deleteRoom(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

}
