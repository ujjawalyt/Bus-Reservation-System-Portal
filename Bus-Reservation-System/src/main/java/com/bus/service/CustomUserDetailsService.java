package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bus.entity.Admin;
import com.bus.entity.Customer;
import com.bus.repository.AdminRepository;
import com.bus.repository.CustomerRepository;
@Service
public class CustomUserDetailsService   {

//	implements UserDetailsService

	
//	@Autowired
//	private AdminRepository adminRepository;
//	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//	Admin admin = adminRepository.findByUsername(username);
//		if (admin != null) {
//			return User.builder()
//					.username(admin.getUsername())
//					.password(admin.getPassword())
//					.roles(admin.getRole())
//					.build();
//		}
//		
//		Customer customer = customerRepository.findByUsername(username);
//		if (customer != null) {
//			return User.builder()
//					.username(customer.getUsername())
//					.password(customer.getPassword())
//					.roles(customer.getRole())
//					.build();
//		}
//		
//		throw new UsernameNotFoundException("User '" + username + "' not found.");
//	}
	

}
