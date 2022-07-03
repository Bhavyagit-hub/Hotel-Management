package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="room_table")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="room_image")
	@NotEmpty
	private String image;
	
	@Column(name="room_number")
	@NotEmpty
	@Size(min=2 ,max=4, message="roomNumber must be between 2- 4 digits")
	private String roomNumber;
	
	@Column(name="room_type")
	@NotEmpty
	@Size(min=4 , message="roomType must contain atleast 4 characters")
	private String roomType;
	
	@Column(name="room_price")
	@NotNull
	private int roomPrice;
	
	@Column(name="room_details")
	@NotEmpty
	@Size(min=5 , message="roomDetails must contain atleast 5 characters")
	private String roomDetails;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Hotel hotel;

	public Room()
	{
		
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	

}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getRoomDetails() {
		return roomDetails;
	}
	public void setRoomDetails(String roomDetails) {
		this.roomDetails = roomDetails;
	}
	

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomPrice=" + roomPrice + ", hotel=" + hotel
				+ "]";
	}
}