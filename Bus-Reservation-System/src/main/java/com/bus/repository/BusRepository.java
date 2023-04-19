package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Buses;

public interface BusRepository extends JpaRepository<Buses, Long> {

	public List<Buses> findByBusType(String busType);
}
