package com.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bus.dto.CustomerDTO;
import com.bus.entity.Customer;
import com.bus.exception.CustomerNotFoundException;
import com.bus.repository.CustomerRepository;

import io.swagger.annotations.Authorization;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException {
		Customer isExsisting =customerRepository.findByMobileNumber(customer.getMobileNumber());
		if(isExsisting!=null) {
			throw new CustomerNotFoundException("Customer already present with this mobile number"+ customer.getMobileNumber());
		}
//		String password = customer.getPassword();
//		customer.setPassword(bCryptPasswordEncoder.encode(password)); // encode the password using BCryptPasswordEncoder
        return customerRepository.save(customer);
		
		
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long customerId) throws CustomerNotFoundException {
		Optional<Customer> customer=customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer is found with this id -"+customerId);
		}
		Customer updateCustomer=customer.get();
		
		updateCustomer.setEmail(customerDTO.getEmail());
		updateCustomer.setFirstName(customerDTO.getFirstName());
		updateCustomer.setLastName(customerDTO.getLastName());
		updateCustomer.setMobileNumber(customerDTO.getMobileNumber());
		updateCustomer.setPassword(customerDTO.getPassword());
		updateCustomer.setUsername(customerDTO.getUsername());
		
		customerRepository.save(updateCustomer);
		return customerDTO;
		
	}

	@Override
	public String deleteCustomer(Long customerId) throws CustomerNotFoundException {
		Optional<Customer> customer=customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer is found with this id -"+customerId);
		}
		customerRepository.delete(customer.get());
		return "Customer Deleted successfully with this id-" +customerId;
	}

	@Override
	public Customer viewCustomerById(Long customerId) throws CustomerNotFoundException {
		Optional<Customer> customer=customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer is found with this id -"+customerId);
		}
		return customer.get();
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerNotFoundException {
		List<Customer> listOfCustomers=customerRepository.findAll();
		return listOfCustomers;
	}
	
	
}
