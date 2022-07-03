package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Hotel;

public interface HotelService {
	Hotel addHotel(Hotel hotel,long placeId);
	List<Hotel> getAllHotels(long placeId);
	Hotel getHotelById(long id);
	Hotel updateHotel(Hotel hotel, long id);
	void deleteHotel(long id);
}
