package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facilities_table")
public class Facilities {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="facility_id")
	private long facilityId;
	@Column(name="facility_image")
	@NotEmpty
	private String image;
	
	@Column(name="facility_name")
	@NotEmpty
	@Size(min=3 , message="facilityName must contain atleast 3 characters")
	private String facilityName;
	
	@Column(name="available_time")
	@NotEmpty
	private String availableTime;
	
	@ManyToOne
	@JoinColumn(name="hotel__id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
    private Hotel hotel;
	
	public Facilities()
	{
	}

	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Facilities [facilityId=" + facilityId + ", facilityName=" + facilityName + ", availableTime=" + availableTime
				+ ", hotel=" + hotel + "]";
	}
	
	}
