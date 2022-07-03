package com.example.demo.serviceImpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Booking;
import com.example.demo.model.Customer;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.HotelService;
import com.example.demo.service.RoomService;
@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private CustomerService customerService;


	 public BookingServiceImpl(BookingRepository bookingRepository, HotelService hotelService, RoomService roomService,CustomerService customerService) {
		     super();
		     this.bookingRepository = bookingRepository;
		     this.hotelService = hotelService;
		     this.roomService = roomService;
	      	 this.customerService = customerService;

	            }



	@Override
	public Booking addBooking(Booking booking,long hotel_id,long roomId,long customerId)
	    {
		Hotel hotel=hotelService.getHotelById(hotel_id);
		Room room=roomService.getRoomById(roomId);
		Customer customer=customerService.getCustomerById(customerId);
		booking.setHotelName(hotel.getHotelName());
		booking.setHotelPlace(hotel.getHotelPlace());
		booking.setRoomNumber(room.getRoomNumber());
		booking.setRoomPrice(room.getRoomPrice());
		booking.setRoomType(room.getRoomType());
		booking.setRoomId(room.getRoomId());
        booking.setCustomer(customer);
		return bookingRepository.save(booking);
	      }



	@Override
	public List<Booking> getAllBookings() 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date= new java.util.Date();
		String currentDate=sdf.format(date);
		String [] array=currentDate.split("/");
		int month=Integer.parseInt(array[0]);
		int day=Integer.parseInt(array[1]);
		int year=Integer.parseInt(array[2]);
		java.util.Date d=new java.util.Date(month,day,year);
		System.out.println(d);
		List<Booking> bookings=bookingRepository.findAll();
		System.out.println(bookings);
		for(Booking book:bookings)
           {
			String checkOut=sdf.format(book.getCheckOut());
			System.out.println(checkOut);
			String []array1=checkOut.split("/");
			int month1=Integer.parseInt(array1[0]);
			int day1=Integer.parseInt(array1[1]);
			int year1=Integer.parseInt(array1[2]);
			java.sql.Date d1=new java.sql.Date(month1,day1,year1);
			
			if(d.compareTo(d1)>0)
			{
				System.out.println("deleted");
				bookingRepository.deleteById(book.getBookingId());
			}

            }

		return bookingRepository.findAll();
	}



	@Override
	public List<Booking> getBookingByCustomerId(long customerId) {
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date= new java.util.Date();
		String currentDate=sdf.format(date);
		String [] array=currentDate.split("/");
		int month=Integer.parseInt(array[0]);
		int day=Integer.parseInt(array[1]);
		int year=Integer.parseInt(array[2]);
		java.util.Date d=new java.util.Date(month,day,year);
		System.out.println(d);
		List<Booking> bookings=bookingRepository.findByCustomerCustomerId(customerId);
		System.out.println(bookings);
		for(Booking book:bookings)
           {
			String checkOut=sdf.format(book.getCheckOut());
			System.out.println(checkOut);
			String []array1=checkOut.split("/");
			int month1=Integer.parseInt(array1[0]);
			int day1=Integer.parseInt(array1[1]);
			int year1=Integer.parseInt(array1[2]);
			java.sql.Date d1=new java.sql.Date(month1,day1,year1);

			if(d.compareTo(d1)>0)
			{
				System.out.println("deleted");
				bookingRepository.deleteById(book.getBookingId());
			}
            }
		    return bookingRepository.findByCustomerCustomerId(customerId);
	}
    @Override
	public List<Booking> getAllBookingsByRoomId(long roomId)
	{
		return bookingRepository.findByRoomId(roomId);

	}
	@Override
    public Boolean	getAvailability(Date checkIn,Date checkOut,long roomId)
      {
		Boolean status = null;
		int count=0;

		List<Booking> booking=this.getAllBookingsByRoomId(roomId);
		
		for(Booking book:booking)
		{

			if((checkIn.compareTo(book.getCheckIn())>0&&checkIn.compareTo(book.getCheckOut())<0)
				||(checkOut.compareTo(book.getCheckIn())>0&&checkOut.compareTo(book.getCheckOut())<0)
				||(checkIn.compareTo(book.getCheckIn())<0&&checkOut.compareTo(book.getCheckOut())>0)
				||(checkIn.compareTo(book.getCheckIn())==0)||(checkIn.compareTo(book.getCheckOut())==0)
				||(checkOut.compareTo(book.getCheckOut())==0)||(checkOut.compareTo(book.getCheckIn())==0))
					
			       {
                	count++;
			
			       }
			}
		
		if(count>=1)
		{
			 status=true;
		}
		else
		{
			System.out.println("**************************");

			status=false;
		}
		return status;
}
	
	@Override
	public Booking updateBooking(Booking booking, long id) {
		Booking existingBooking=bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking","Id",id));
		existingBooking.setHotelName(booking. getHotelName());
		existingBooking.setHotelPlace(booking.getHotelPlace());
		existingBooking.setRoomNumber(booking.getRoomNumber());
		existingBooking.setRoomPrice(booking.getRoomPrice());
		existingBooking.setRoomType(booking.getRoomType());
		existingBooking.setCustomer(booking.getCustomer());
		existingBooking.setBookedDate(booking.getBookedDate());
		existingBooking.setCheckIn(booking.getCheckIn());
		existingBooking.setCheckOut(booking.getCheckOut());
		existingBooking.setRoomId(booking.getRoomId());

		bookingRepository.save(existingBooking);
		return existingBooking;
	}



	@Override
	public void deleteBooking(long id) {
		bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking","Id",id));
		bookingRepository.deleteById(id);
		
	}
	
	
}
