package com.bus.service;

import org.springframework.stereotype.Service;

import com.bus.dto.CustomerLoginDto;
import com.bus.exception.CustomerNotFoundException;

@Service
public interface CustomerLoginService {

	public String logIntoAccount(CustomerLoginDto customerLoginDto) throws CustomerNotFoundException;
	public String logoutFromAccount(String key) throws CustomerNotFoundException;
}
