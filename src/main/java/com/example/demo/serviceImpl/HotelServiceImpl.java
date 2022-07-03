package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.HotelNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Hotel;
import com.example.demo.model.Place;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
import com.example.demo.service.PlaceService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private PlaceService placeService;

	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}



	@Override
	public Hotel addHotel(Hotel hotel,long placeId) {

		Place place=placeService.getPlaceById(placeId);
		hotel.setPlace(place);
		return hotelRepository.save(hotel);
	}



	@Override
	public List<Hotel> getAllHotels(long placeId) {
		return hotelRepository.findByPlacePlaceId(placeId);
	}



	@Override
	public Hotel getHotelById(long id) {
		
		return hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException("Hotel","Id",id));
	}



	@Override
	public Hotel updateHotel(Hotel hotel, long id) {
		Hotel existingHotel=hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException("Hotel","Id",id));
		existingHotel.setHotelName(hotel. getHotelName());
		existingHotel.setHotelPlace(hotel.getHotelPlace());

		existingHotel.setImage(hotel. getImage());
		existingHotel.setHotelDetails(hotel. getHotelDetails());

		
		hotelRepository.save(existingHotel);
		return existingHotel;
	}



	@Override
	public void deleteHotel(long id) {
		hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException("Hotel","Id",id));
		hotelRepository.deleteById(id);
		
	}
	
}
