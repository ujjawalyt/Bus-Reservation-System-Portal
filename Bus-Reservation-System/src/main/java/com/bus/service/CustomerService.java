package com.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.dto.CustomerDTO;
import com.bus.entity.Customer;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;

@Service
public interface CustomerService {

	
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException;
	
	public CustomerDTO updateCustomer (CustomerDTO customerDTO, Long customerId) throws CustomerNotFoundException,LoginException;
	
	public String deleteCustomer(Long customerId) throws CustomerNotFoundException,LoginException;
	
	public Customer viewCustomerById(Long customerId) throws CustomerNotFoundException,LoginException;
	
	public List<Customer> viewAllCustomer(String key) throws CustomerNotFoundException,AdminNotFoundException;
}
