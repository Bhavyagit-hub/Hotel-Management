package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Facilities;
import com.example.demo.model.Room;

@Repository
public interface FacilitiesRepository extends JpaRepository<Facilities, Long>{
	public List<Facilities> findByHotelId(long hotelId);

}
