package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hotel_table")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="hotel_id")
	private long id;
	
	@Column(name="image")
	@NotEmpty
	private String image;
	
	@Column(name="hotel_name")
	@NotEmpty
	@Size(min=3 , message="hotelName must contain atleast 3 characters")
	private String hotelName;
	
	@Column(name="hotel_place")
	@NotEmpty
	@Size(min=3 , message="hotelPlace must contain atleast 3 characters")
	private String hotelPlace;
	
	@Column(name="hotel_details")
	@NotEmpty
	@Size(min=8 , message="hotelDetails must contain atleast 8 characters")
	private String hotelDetails;
	
	@OneToMany(mappedBy="hotel", cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Room> room;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="place_id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Place place;
	
	@OneToMany(mappedBy="hotel", cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Facilities> facilities;
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Hotel()
	{}
		

	public String getHotelPlace() {
		return hotelPlace;
	}

	public void setHotelPlace(String hotelPlace) {
		this.hotelPlace = hotelPlace;
	}
	
		public List<Facilities> getFacilities() {
		return facilities;
	}

    public void setFacilities(List<Facilities> facilities) {
		this.facilities = facilities;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
}
	
public String getHotelDetails() {
		return hotelDetails;
	}
	public void setHotelDetails(String hotelDetails) {
		this.hotelDetails = hotelDetails;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", image=" + image + ", hotelName=" + hotelName + ", hotelPlace=" + hotelPlace
				+ ", hotelDetails=" + hotelDetails + ", room=" + room + ", place=" + place + ", facilities="
				+ facilities + "]";
	}

	

}
