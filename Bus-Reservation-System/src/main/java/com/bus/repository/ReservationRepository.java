package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{

}
