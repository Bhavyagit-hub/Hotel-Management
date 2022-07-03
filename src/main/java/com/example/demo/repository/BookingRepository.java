package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Payement;
import com.example.demo.model.Room;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	public List<Booking> findByCustomerCustomerId(long customerId);
	public List<Booking> findByRoomId(long roomId);
	public void deleteByRoomId(long roomId);

}
