package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Facilities;

public interface FacilitiesService {
	Facilities addFacility(Facilities facilities,long hotelId);
	List<Facilities> getAllFacilities(long hotelId);
	Facilities getFacilityById(long id);
	Facilities updateFacility(Facilities facilities, long id);
	void deleteFacility(long id);
}
