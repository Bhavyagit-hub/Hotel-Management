package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Booking;

public interface BookingService {
	Booking addBooking(Booking booking,long id, long roomId,long customerId);
	
	Booking updateBooking(Booking booking,long id);
	List<Booking> getBookingByCustomerId(long customerId);
	List<Booking> getAllBookings();
	List<Booking> getAllBookingsByRoomId(long roomId);
	void deleteBooking(long id);
	Boolean getAvailability(Date checkIn,Date checkOut,long roomId);
}
