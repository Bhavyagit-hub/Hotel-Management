package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Payement;
import com.example.demo.model.Room;
@Repository
public interface PayementRepository extends JpaRepository<Payement, Long>{
	public List<Payement> findByRoomId(long roomId);

}
