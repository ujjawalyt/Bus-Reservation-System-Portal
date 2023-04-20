package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.CurrentCustomerSession;

public interface CurrrentCustomerSessionDao  extends JpaRepository<CurrentCustomerSession, Long>{

	public CurrentCustomerSession findByCustomerKey(String key);
}
