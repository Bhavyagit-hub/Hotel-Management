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
import com.example.demo.model.Room;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.RoomRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class RoomTestCase {
	@Autowired
	RoomRepository roomRepository;
	//checking Place name
		@Test
		@Order(1)
		public void testSingleRoom()
		{
		Room room=this.roomRepository.findById(5L).get();
		assertEquals(5000,room.getRoomPrice(),0);
		}

	
	//updating place name
	@Test
	@Order(2)
	public void testUpdate()
	{
		Room room=this.roomRepository.findById(5L).get();
		room.setRoomPrice(10000);
	this.roomRepository.save(room);
	assertNotEquals(5000,this.roomRepository.findById(5L).get().getRoomPrice());
	
	}
	
	
	//deleting product
	@Test
	@Order(3)
	public void testDeleteRoom()
	{
		roomRepository.deleteById(5L);
	assertFalse(roomRepository.existsById(5L));
	}
}

