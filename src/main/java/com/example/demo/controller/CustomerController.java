package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Facilities;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.service.CustomerService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController // is controller which provides different end points to access the services

@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	/*
	 * public CustomerController(CustomerService customerService) { super();
	 * this.customerService = customerService; }
	 */

//Register
	//http://localhost:8084/register
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}

//Login
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.loginCustomer(customer), HttpStatus.OK);

	}

//Update Customer	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}

//Get All Customer	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// get customer by email
	@PostMapping("/forgotpass")
	public Customer getCustomerByEmail(@RequestBody Customer customer) {
		return customerService.getCustomerByEmail(customer);
	}

	// get customer by id
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}

//Delete Customer	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}