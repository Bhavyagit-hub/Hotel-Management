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

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.service.HotelService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	/*
	 * public HotelController(HotelService hotelService) { super();
	 * this.hotelService = hotelService; }
	 */

//to add hotels
	@PostMapping("{placeId}")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel, @PathVariable long placeId) {
		System.out.println("********************");
		return new ResponseEntity<Hotel>(hotelService.addHotel(hotel, placeId), HttpStatus.CREATED);
	}

	// to get hotels in particular place
	@GetMapping("{placeId}")
	public List<Hotel> getAllHotels(@PathVariable long placeId) {
		return hotelService.getAllHotels(placeId);
	}

	// to get hotel details
	@GetMapping("hotels/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id") long hotelID) {
		return new ResponseEntity<Hotel>(hotelService.getHotelById(hotelID), HttpStatus.OK);
	}

	// update hotel
	@PutMapping("{id}")
	public ResponseEntity<Hotel> updateHotel(@Valid @PathVariable("id") long id, @RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel, id), HttpStatus.OK);
	}

	// delete hotel
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteHotel(@PathVariable long id) {
		hotelService.deleteHotel(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
