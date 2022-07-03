package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PlaceNotFoundException;
import com.example.demo.model.Place;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.PlaceService;
@Service
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	private PlaceRepository placeRepository;
	
	
	
	public PlaceServiceImpl(PlaceRepository placeRepository) {
		super();
		this.placeRepository = placeRepository;
	}

	@Override
	public Place addPlace(Place place) {
		// TODO Auto-generated method stub
		
		return placeRepository.save(place);
	}

	@Override
	public List<Place> getAllPlaces() {
		// TODO Auto-generated method stub
		return placeRepository.findAll();
	}

	@Override
	public Place getPlaceById(long id) {
	
		return placeRepository.findById(id).orElseThrow(()->new PlaceNotFoundException("Place","Id",id));
	}

	@Override
	public Place updatePlace(Place place, long id) {
		// TODO Auto-generated method stub
		Place existingPlace=placeRepository.findById(id).orElseThrow(()->new PlaceNotFoundException("Place","Id",id));
		existingPlace.setPlaceName(place.getPlaceName());
		existingPlace.setImage(place.getImage());
		placeRepository.save(existingPlace);
		return existingPlace;
	}



	@Override
	public void deletePlace(long id) {
		// TODO Auto-generated method stub
		placeRepository.findById(id).orElseThrow(()->new PlaceNotFoundException("Place","Id",id));
		placeRepository.deleteById(id);
		
	}
	
}
