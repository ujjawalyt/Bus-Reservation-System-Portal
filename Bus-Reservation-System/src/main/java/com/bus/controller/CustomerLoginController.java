package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.CustomerLoginDto;
import com.bus.exception.CustomerNotFoundException;
import com.bus.service.CustomerLoginService;



@RestController
@RequestMapping("/customer")
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> logIntoAccountHandler
	(@RequestBody CustomerLoginDto customerLoginDto) throws CustomerNotFoundException{
		
		return new ResponseEntity<String>
		(customerLoginService.logIntoAccount(customerLoginDto),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> logOutFromAccountHandler
	(@PathVariable("key")String key)  throws CustomerNotFoundException{
		
		return new ResponseEntity<String>
		(customerLoginService.logoutFromAccount(key),HttpStatus.ACCEPTED);
		
	}
}
