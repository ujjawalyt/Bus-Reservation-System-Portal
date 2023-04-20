package com.bus.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.CustomerLoginDto;
import com.bus.entity.Admin;
import com.bus.entity.AdminCurrentSession;
import com.bus.entity.CurrentCustomerSession;
import com.bus.entity.Customer;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.repository.CurrrentCustomerSessionDao;
import com.bus.repository.CustomerRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CurrrentCustomerSessionDao currrentCustomerSessionDao;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String logIntoAccount(CustomerLoginDto customerLoginDto) throws CustomerNotFoundException {
	
		Customer customer = customerRepository.findByUsername(customerLoginDto.getUsername());
		
		if(customer==null) {
			throw new CustomerNotFoundException("customer with this username is not present");
		}
	
		Optional<CurrentCustomerSession> isPresentCustomer = currrentCustomerSessionDao.findById(customer.getCustomerId());
		
		if(isPresentCustomer.isPresent()) {
			throw new CustomerNotFoundException("customer with this username is already present");
		}
		if(customer.getPassword().equals(customerLoginDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentCustomerSession currentCustomerSession = new CurrentCustomerSession(customer.getCustomerId(), key, LocalDateTime.now());
			currrentCustomerSessionDao.save(currentCustomerSession);
			return "Loggin Succesfully with this key : " + key;
			
			
		}else {
			throw new CustomerNotFoundException("password is incorrect...!");
		}
			
			
		
	}

	@Override
	public String logoutFromAccount(String key) throws CustomerNotFoundException {
		
		

		CurrentCustomerSession currentCustomerSession =currrentCustomerSessionDao.findByCustomerKey(key);
		if(currentCustomerSession==null) {
			throw new CustomerNotFoundException("Incorrect key..");
			
		}
		currrentCustomerSessionDao.delete(currentCustomerSession);
		return "Logout From Account..";
		
		
		
	}
	
	
}
