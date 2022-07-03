package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerTestCase {

@Autowired
CustomerRepository customerRepository;




//adding customer
@Test
@Order(1)
public void testCreate()
{

Customer customer=new Customer();
customer.setFirstName("Ashwith");
customer.setLastName("Kunder");
customer.setPhoneNumber("9880676232");
customer.setGender("Male");
customer.setDistrict("Udupi");
customer.setState("Karnataka");
customer.setZipCode("576111");
customer.setEmailID("ash@gmail.com");
customer.setPassword("Realme3pro");
customerRepository.save(customer);
assertNotNull(customerRepository.findById(2L).get());
}




//deleting customer
@Test
@Order(3)
public void testDelete()
{
customerRepository.deleteById(1L);
assertFalse(customerRepository.existsById(1L));
}



}