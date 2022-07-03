package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Room;

public interface RoomService {
	Room addRoom(Room room,long hotelId);
    List<Room> getAllRooms( long hotelId );
	Room getRoomById(long id);
	Room updateRoom(Room room, long id);
	void deleteRoom(long id);
}
