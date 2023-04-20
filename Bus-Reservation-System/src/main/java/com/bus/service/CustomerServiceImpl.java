package com.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bus.dto.CustomerDTO;
import com.bus.entity.AdminCurrentSession;
import com.bus.entity.CurrentCustomerSession;
import com.bus.entity.Customer;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;
import com.bus.repository.CurrentAdminSessionDao;
import com.bus.repository.CurrentCustomerSessionDao;
import com.bus.repository.CustomerRepository;

import io.swagger.annotations.Authorization;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CurrentCustomerSessionDao currentCustomerSessionDao;
	
	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException {
		Customer isExsisting = customerRepository.findByMobileNumber(customer.getMobileNumber());
		if (isExsisting != null) {
			throw new CustomerNotFoundException(
					"Customer already present with this mobile number" + customer.getMobileNumber());
		}
//		String password = customer.getPassword();
//		customer.setPassword(bCryptPasswordEncoder.encode(password)); // encode the password using BCryptPasswordEncoder
		return customerRepository.save(customer);

	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long customerId)
			throws CustomerNotFoundException, LoginException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {

			Customer updateCustomer = customer.get();

			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(updateCustomer.getCustomerId());
			if (isCurrent.isPresent()) {
				updateCustomer.setEmail(customerDTO.getEmail());
				updateCustomer.setFirstName(customerDTO.getFirstName());
				updateCustomer.setLastName(customerDTO.getLastName());
				updateCustomer.setMobileNumber(customerDTO.getMobileNumber());
				updateCustomer.setPassword(customerDTO.getPassword());
				updateCustomer.setUsername(customerDTO.getUsername());

				customerRepository.save(updateCustomer);
				return customerDTO;
			} else {
				throw new LoginException("Customer is not logged in..");
			}

		} else {
			throw new CustomerNotFoundException("No customer is found with this id -" + customerId);
		}

	}

	@Override
	public String deleteCustomer(Long customerId) throws CustomerNotFoundException, LoginException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {

			Customer updateCustomer = customer.get();

			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(updateCustomer.getCustomerId());
			if (isCurrent.isPresent()) {
				customerRepository.delete(customer.get());
				return "Customer Deleted successfully with this id-" + customerId;
				
			} else {
				throw new LoginException("Customer is not logged in..");
			}

		} else {
			throw new CustomerNotFoundException("No customer is found with this id -" + customerId);
		}
	
	}

	@Override
	public Customer viewCustomerById(Long customerId) throws CustomerNotFoundException, LoginException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {

			Customer updateCustomer = customer.get();

			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(updateCustomer.getCustomerId());
			if (isCurrent.isPresent()) {
				return customer.get();
				
			} else {
				throw new LoginException("Customer is not logged in..");
			}
		}else {
			throw new CustomerNotFoundException("No customer is found with this id -" + customerId);
		}
		
	}

	@Override
	public List<Customer> viewAllCustomer(String key) throws CustomerNotFoundException, AdminNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		List<Customer> listOfCustomers = customerRepository.findAll();
		return listOfCustomers;
	}

}
