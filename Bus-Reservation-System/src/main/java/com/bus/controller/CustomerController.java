package com.bus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.CustomerDTO;
import com.bus.entity.Customer;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;
import com.bus.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> postNewCustomer_Handler(@Valid @RequestBody CustomerDTO customer)  throws CustomerNotFoundException{
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer_Handler(@RequestBody CustomerDTO customerDTO,
			@PathVariable("id") Long id)  throws CustomerNotFoundException,LoginException{
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(customerDTO, id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer_Handler(@PathVariable("id") Long id)  throws CustomerNotFoundException,LoginException{
		return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
	}
	@GetMapping("/view/{id}")
	public ResponseEntity<Customer> getCustomerById_Handler(@PathVariable("id") Long id)  throws CustomerNotFoundException,LoginException{
		return new ResponseEntity<Customer>(customerService.viewCustomerById(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewall/{key}")
	public ResponseEntity<List<Customer>> getAllCustomer_Handler(@PathVariable("key") String key)  throws CustomerNotFoundException,AdminNotFoundException{
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomer(key),HttpStatus.ACCEPTED);
	}
}
