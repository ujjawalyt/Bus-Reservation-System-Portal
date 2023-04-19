package com.bus.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {

	public Customer findByMobileNumber(String mobileNumber);
}
