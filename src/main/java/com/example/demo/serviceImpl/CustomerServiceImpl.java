package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
private CustomerRepository customerRepository;
	
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerById(long id) {
		
		return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer","Id",id));
	}


	@Override
	public Customer saveCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	@Override
	public Customer loginCustomer(Customer customer) {
		
		return this.customerRepository.findByEmailIDAndPassword(customer.emailID,customer.password).orElseThrow(()->new CustomerNotFoundException("Customer ", "Id",customer.emailID+" and password "+customer.password ));
	}
	public Customer getCustomerByEmail(Customer customer)
	{
		return this.customerRepository.findByEmailID(customer.emailID).orElseThrow(()->new CustomerNotFoundException("Customer ", "Email",customer.emailID ));
	}


	@Override
	public Customer updateCustomer(Customer customer,long id) {
	
	Customer existingCustomer=customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer","Id",id));	
	existingCustomer.setFirstName(customer.getFirstName());
	existingCustomer.setLastName(customer.getLastName());
	existingCustomer.setDateOfBirth(customer.getDateOfBirth());
	existingCustomer.setDistrict(customer.getDistrict());
	existingCustomer.setPhoneNumber(customer.getPhoneNumber());
	existingCustomer.setState(customer.getState());
	existingCustomer.setZipCode(customer.getZipCode());
	existingCustomer.setEmailID(customer.getEmailID());
	existingCustomer.setPassword(customer.getPassword());
	customerRepository.save(existingCustomer);
	return existingCustomer;
	}



	@Override
	public List<Customer> getAllCustomers() {
	
		return customerRepository.findAll();
	}



	@Override
	public void deleteCustomer(long id) {
		customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer","Id",id));
		customerRepository.deleteById(id);
		
	}
	


}
