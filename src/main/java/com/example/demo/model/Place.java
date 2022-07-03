package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="place_table")
public class Place {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="place_id")

private long placeId;
	@Column(name="place_name")
	@NotEmpty
	@Size(min=3 , message="placeName must contain atleast 3 characters")
private String placeName;
	@Column(name="image")
	@NotEmpty
	private String image;
	@OneToMany(mappedBy="place", cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Hotel> hotel;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
    public List<Hotel> getHotel() {
		return hotel;
	}
	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}
    public long getPlaceId() {
	return placeId;
     }
     public void setPlaceId(long placeId) {
	this.placeId = placeId;
     }
     public String getPlaceName() {
	return placeName;
      }
    public void setPlaceName(String placeName) {
	this.placeName = placeName;
}


}
