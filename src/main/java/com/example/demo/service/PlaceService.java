package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Place;

public interface PlaceService {
	Place addPlace(Place place);
	List<Place> getAllPlaces();
	Place getPlaceById(long placeId);
	Place updatePlace(Place place, long id);
	void deletePlace(long id);
}
