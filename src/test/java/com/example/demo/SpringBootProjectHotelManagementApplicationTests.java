package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.model.Hotel;
import com.example.demo.model.Place;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.PlaceRepository;


//package com.example.demo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class SpringBootProjectHotelManagementApplicationTests {
@Autowired	
private AdminRepository adminRepository;
private CustomerRepository customerRepository;
private PlaceRepository placeRepository;




	@Test
	public void testCreate()  {
		Admin admin=new Admin();
	admin.setFirstName("Bharath");
	admin.setLastName("Gowda");
admin.setAdminEmailId("bharath@gmail.com");
	admin.setAdminPassword("Asus12312");

		
		assertNotNull(	adminRepository.save(admin));
	
   
	   
	}
//	@Test
//	public void testCreateForCustomer()  {
//		Customer cust=new Customer();
//		cust.setFirstName("Bharath");
//		cust.setLastName("Gowda");
//		cust.setDistrict("Udupi");
//		cust.setState("karnataka");
//		cust.setZipCode("576111");
//		cust.setGender("Male");
//		cust.setPhoneNumber("9008707293");
//		cust.setEmailID("bharath@gmail.com");
//		cust.setPassword("Dell123456789");
//		cust.setDateOfBirth("2000-05-26");
//assertNotNull(	customerRepository.save(cust));
//
//   
//	   
//	}
	
//	@Test
//	public void testReadAllCustomer()  {
//		List<Customer> cust=customerRepository.findAll();
//		
//assertThat(cust).size().isGreaterThan(0);
//
//   
//	   
//	}
	@Test
	public void testCreatePlace()  {
		Place place=new Place();
		place.setImage(".assets\\kashmir.jpg");
		place.setPlaceName("Kashmir");
		assertNotNull(	placeRepository.save(place));
	
    }
//	@Test
//	public void testReadAllPlace()  {
//		List<Place> place=placeRepository.findAll();
//		
//assertThat(place).size().isGreaterThan(0);
//	}
	
//	@Test
//	public void testUpdatePlace()  {
//		Place place=placeRepository.findById(12L).get();
//		place.setPlaceName("Jaipur City");
//		placeRepository.save(place);
//		assertNotEquals("Jaipur",placeRepository.findById(12L).get().getPlaceName() );
//		
//}
//	@Test
//	public void testDeletePlace()  {
//		placeRepository.deleteById(12L);
//		assertThat(placeRepository.existsById(12L)).isFalse();
//		
//
//	}
}
