package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.model.Hotel;
import com.example.demo.model.Place;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.PlaceRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class HotelTestCase {
	@Autowired
	HotelRepository hotelRepository;
	//checking Place name
		@Test
		@Order(1)
		public void testSinglePlace()
		{
		Hotel hotel=this.hotelRepository.findById(1L).get();
		assertEquals("MG Road",hotel.getHotelPlace(),"");
		}

	
	//updating place name
	@Test
	@Order(2)
	public void testUpdate()
	{
		Hotel hotel=this.hotelRepository.findById(1L).get();
		hotel.setHotelPlace("Banglore");
	this.hotelRepository.save(hotel);
	assertNotEquals(500.00,this.hotelRepository.findById(1L).get().getHotelPlace());
	
	}
	
	
	//deleting product
	@Test
	@Order(3)
	public void testDeleteHotel()
	{
		hotelRepository.deleteById(1L);
	assertFalse(hotelRepository.existsById(1L));
	}
}
