package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Hotel;
import com.example.demo.model.Payement;

public interface PayementService {
	Payement addPayement(Payement payement,long roomId,long customerId, long hotelId);
	List<Payement> getAllPayements();
	Payement getPayementById(long id);
	void deletePayement(long id);
	public List<Payement> getAllPayementsByRoomId(long roomId);
}
