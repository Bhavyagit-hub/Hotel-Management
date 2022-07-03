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
import com.example.demo.model.Place;
import com.example.demo.service.HotelService;
import com.example.demo.service.PlaceService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/places")
public class PlaceController {
	@Autowired
	private PlaceService placeService;

	/*
	 * public PlaceController(PlaceService placeService) { super();
	 * this.placeService = placeService; }
	 */

	// to add palce
	@PostMapping
	public ResponseEntity<Place> addPlace(@Valid @RequestBody Place place) {
		System.out.println(place);
		return new ResponseEntity<Place>(placeService.addPlace(place), HttpStatus.CREATED);
	}

	// to get all place
	@GetMapping
	public List<Place> getAllPlaces() {
		return placeService.getAllPlaces();
	}

	// to get hotel by hotelid
	@GetMapping("{id}")
	public ResponseEntity<Place> getHotelById(@PathVariable("id") long placeId) {
		return new ResponseEntity<Place>(placeService.getPlaceById(placeId), HttpStatus.OK);
	}

	// to update hotel
	@PutMapping("{id}")
	public ResponseEntity<Place> updatePlace(@Valid @PathVariable("id") long id, @RequestBody Place place) {
		return new ResponseEntity<Place>(placeService.updatePlace(place, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deletePlace(@PathVariable long id) {
		placeService.deletePlace(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
