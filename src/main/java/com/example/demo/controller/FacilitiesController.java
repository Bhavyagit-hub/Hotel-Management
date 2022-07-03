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

import com.example.demo.model.Facilities;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.service.FacilitiesService;
import com.example.demo.service.HotelService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

@RequestMapping("/api/facilities")
public class FacilitiesController {
	@Autowired
	private FacilitiesService facilitiesService;

	/*
	 * public FacilitiesController(FacilitiesService facilitiesService) { super();
	 * this.facilitiesService = facilitiesService;
	 * 
	 * }
	 */

	// Adding facilities through hotelId
	@PostMapping("{hotelId}")
	public ResponseEntity<Facilities> addFacility(@Valid @RequestBody Facilities facilities,
			@PathVariable long hotelId) {

		return new ResponseEntity<Facilities>(facilitiesService.addFacility(facilities, hotelId), HttpStatus.CREATED);
	}

	// getting list of facilities under particular hotel(by hotelId)
	@GetMapping("{hotelId}")
	public List<Facilities> getAllFacilities(@PathVariable long hotelId) {
		return facilitiesService.getAllFacilities(hotelId);
	}

	// to get list of facilities by facilitiesId

	@GetMapping("facilities/{id}")
	public ResponseEntity<Facilities> getFacilityById(@PathVariable("id") long facilityID) {
		return new ResponseEntity<Facilities>(facilitiesService.getFacilityById(facilityID), HttpStatus.OK);
	}

	// to update facility
	@PutMapping("{id}")
	public ResponseEntity<Facilities> updateFacility(@Valid @PathVariable("id") long id,
			@RequestBody Facilities facilities) {
		return new ResponseEntity<Facilities>(facilitiesService.updateFacility(facilities, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteFacility(@PathVariable("id") long id) {
		facilitiesService.deleteFacility(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
