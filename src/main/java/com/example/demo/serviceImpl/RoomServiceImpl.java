package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RoomNotFoundException;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.HotelService;
import com.example.demo.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private HotelService hotelService;

	
	public RoomServiceImpl(RoomRepository roomRepository,HotelService hotelService) {
		super();
		this.roomRepository = roomRepository;
		this.hotelService = hotelService;

	}

	@Override
	public Room addRoom(Room room,long hotelId) {
		Hotel hotel=hotelService.getHotelById(hotelId);
		room.setHotel(hotel);
		return roomRepository.save(room);
	}


	@Override
	public List<Room> getAllRooms( long hotelId ) {

     return roomRepository.findByHotelId(hotelId);

	}

	@Override
	public Room getRoomById(long id) {
	
		return roomRepository.findById(id).orElseThrow(()->new RoomNotFoundException("Room","Id",id));
	}




	@Override
	public Room updateRoom(Room room, long id) {
		
		Room existingRooom=roomRepository.findById(id).orElseThrow(()->new RoomNotFoundException("Room","Id",id));
		existingRooom.setImage(room.getImage());		
		existingRooom.setRoomNumber(room.getRoomNumber());
		existingRooom.setRoomType(room. getRoomType());
		existingRooom.setRoomPrice(room.getRoomPrice());
		existingRooom.setRoomDetails(room.getRoomDetails());
		roomRepository.save(existingRooom);
		return existingRooom;
	}


	@Override
	public void deleteRoom(long id) {
	
		roomRepository.findById(id).orElseThrow(()->new RoomNotFoundException("Room","Id",id));
		roomRepository.deleteById(id);
		
	}
	
}
