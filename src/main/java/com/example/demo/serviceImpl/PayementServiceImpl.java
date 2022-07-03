package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PayementNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Hotel;
import com.example.demo.model.Payement;
import com.example.demo.model.Room;
import com.example.demo.repository.PayementRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.HotelService;
import com.example.demo.service.PayementService;
import com.example.demo.service.RoomService;
@Service
public class PayementServiceImpl implements PayementService{
	@Autowired
private PayementRepository payementRepository;
	@Autowired
	private RoomService roomService;
	@Autowired
	private CustomerService customerService;
	
	private HotelService hotelService;


        public PayementServiceImpl(PayementRepository payementRepository, RoomService roomService,
			CustomerService customerService,HotelService hotelService) {
		super();
		this.payementRepository = payementRepository;
		this.roomService = roomService;
		this.customerService = customerService;
		this.hotelService = hotelService;

	}

    @Override
	public Payement addPayement(Payement payement,long roomId,long customerId,long hotelId) {
		// TODO Auto-generated method stub
	Hotel hotel=hotelService.getHotelById(hotelId);
	payement.setHotelName(hotel.getHotelName());
	payement.setHotelPlace(hotel.getHotelPlace());
	Room room=roomService.getRoomById(roomId);
	payement.setRoomId(room.getRoomId());
	payement.setRoomPrice(room.getRoomPrice());
	payement.setRoomNumber(room.getRoomNumber());		
	payement.setRoomType(room.getRoomType());
	Customer customer=customerService.getCustomerById(customerId);
	payement.setFirstName(customer.getFirstName());
	payement.setLastName(customer.getLastName());
	payement.setEmailID(customer.getEmailID());
	payement.setDistrict(customer.getDistrict());
	payement.setState(customer.getState());	
	payement.setZipCode(customer.getZipCode());
	payement.setCustomer(customer);
	     return payementRepository.save(payement);
	}



	@Override
	public List<Payement> getAllPayements() {
		return payementRepository.findAll();
	}
	@Override
	public List<Payement> getAllPayementsByRoomId(long roomId) {
		return payementRepository.findByRoomId(roomId);
	}


	@Override
	public Payement getPayementById(long id) {
		
		return payementRepository.findById(id).orElseThrow(()->new PayementNotFoundException("Payement","Id",id));
	}


    @Override
	public void deletePayement(long id) {
		payementRepository.findById(id).orElseThrow(()->new PayementNotFoundException("Facilities","Id",id));
		payementRepository.deleteById(id);
		
	}
	
}

