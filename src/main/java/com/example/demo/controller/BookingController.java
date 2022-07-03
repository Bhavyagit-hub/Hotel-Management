package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // is controller which provides different end points to access the services

@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	/*
	 * public BookingController(BookingService bookingService) { super();
	 * this.bookingService = bookingService; }
	 */

//adding booking details
	@PostMapping("{id}/{roomId}/{customerId}")
	public ResponseEntity<Booking> addBooking(@PathVariable long id, @PathVariable long roomId,
			@PathVariable long customerId, @RequestBody Booking booking) {

		return new ResponseEntity<Booking>(bookingService.addBooking(booking, id, roomId, customerId),
				HttpStatus.CREATED);
	}

//updating booking details
	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") long id, @RequestBody Booking booking) {
		return new ResponseEntity<Booking>(bookingService.updateBooking(booking, id), HttpStatus.OK);
	}

	// get all booking details
	@GetMapping()
	public List<Booking> getAllBookings() {

		return bookingService.getAllBookings();
	}

	// get booking details by customer id
	@GetMapping("{customerId}")
	public List<Booking> getBookingByCustomerId(@PathVariable long customerId) {
		return bookingService.getBookingByCustomerId(customerId);
	}

	// get booking by room id (to display checkIn and checkOut dates in front-end)
	@GetMapping("rooms/{roomId}")
	public List<Booking> getBookingByRoomId(@PathVariable long roomId) {
		List<Booking> booking = bookingService.getAllBookingsByRoomId(roomId);
		System.out.println(booking);

		return bookingService.getAllBookingsByRoomId(roomId);
	}

	// to check availability of rooms
	@GetMapping("{checkIn}/{checkOut}/{roomId}")
	public ResponseEntity<Boolean> getAvailability(@PathVariable("checkIn") Date checkIn,
			@PathVariable("checkOut") Date checkOut, @PathVariable("roomId") long roomId) {

		return new ResponseEntity<Boolean>(bookingService.getAvailability(checkIn, checkOut, roomId), HttpStatus.OK);

	}

	// to delete or cancel booking
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable("id") long id) {
		bookingService.deleteBooking(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
