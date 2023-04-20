package com.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.dto.CustomerDTO;
import com.bus.entity.Customer;
import com.bus.exception.CustomerNotFoundException;

@Service
public interface CustomerService {

	
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException;
	
	public CustomerDTO updateCustomer (CustomerDTO customerDTO, Long customerId) throws CustomerNotFoundException;
	
	public String deleteCustomer(Long customerId) throws CustomerNotFoundException;
	
	public Customer viewCustomerById(Long customerId) throws CustomerNotFoundException;
	
	public List<Customer> viewAllCustomer() throws CustomerNotFoundException;
}
