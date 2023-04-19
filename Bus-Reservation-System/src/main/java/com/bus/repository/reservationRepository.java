package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Reservation;

public interface reservationRepository  extends JpaRepository<Reservation, Long>{

}
