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

import com.example.demo.model.Place;
import com.example.demo.repository.PlaceRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PlaceTestCase {
	@Autowired
	PlaceRepository placeRepository;
	//checking Place name
		@Test
		@Order(1)
		public void testSinglePlace()
		{
		Place place=this.placeRepository.findById(3L).get();
		assertEquals("Delhi",place.getPlaceName(),"");
		}

	
	//updating place name
	@Test
	@Order(2)
	public void testUpdate()
	{
		Place place=this.placeRepository.findById(3L).get();
		place.setPlaceName("New Delhi");
	this.placeRepository.save(place);
	assertNotEquals(500.00,this.placeRepository.findById(3L).get().getPlaceName());
	
	}
	
	
	//deleting product
	@Test
	@Order(3)
	public void testDeletePlace()
	{
		placeRepository.deleteById(3L);
	assertFalse(placeRepository.existsById(3L));
	}
}
