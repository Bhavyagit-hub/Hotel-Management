package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FacilityNotFoundException;
import com.example.demo.model.Facilities;
import com.example.demo.model.Hotel;
import com.example.demo.repository.FacilitiesRepository;
import com.example.demo.service.FacilitiesService;
import com.example.demo.service.HotelService;


@Service
public class FacilitiesServiceImpl implements FacilitiesService{
	@Autowired
	private FacilitiesRepository facilitiesRepository;
	@Autowired
	private HotelService hotelService;
	
	
	
	public FacilitiesServiceImpl(FacilitiesRepository facilitiesRepository,HotelService hotelService) {
		super();
		this.facilitiesRepository = facilitiesRepository;
		this.hotelService = hotelService;
	}



	@Override
	public Facilities addFacility(Facilities facilities,long hotelId) {
		Hotel hotel=hotelService.getHotelById(hotelId);
		facilities.setHotel(hotel);
		return facilitiesRepository.save(facilities);
	}



	@Override
	public List<Facilities> getAllFacilities(long hotelId) {
		return facilitiesRepository.findByHotelId(hotelId);
	}



	@Override
	public Facilities getFacilityById(long id) {
	
		return facilitiesRepository.findById(id).orElseThrow(()->new FacilityNotFoundException("Facilities","Id",id));
	}



	@Override
	public Facilities updateFacility(Facilities facilities, long id) {
		Facilities existingFacility=facilitiesRepository.findById(id).orElseThrow(()->new FacilityNotFoundException("Facilities","Id",id));
		existingFacility.setFacilityName(facilities. getFacilityName());
		existingFacility.setAvailableTime(facilities.getAvailableTime());
		existingFacility.setImage(facilities.getImage());
		facilitiesRepository.save(existingFacility);
		return existingFacility;
	}



	@Override
	public void deleteFacility(long id) {
		facilitiesRepository.findById(id).orElseThrow(()->new FacilityNotFoundException("Facilities","Id",id));
		facilitiesRepository.deleteById(id);
		
	}
	
}
