package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
	public List<Hotel> findByPlacePlaceId(long placeId);

}


