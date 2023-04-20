package com.bus.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.bus.entity.Reservation;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;
import com.bus.exception.ReservationNotFoundException;

public interface ReservationService {
	public Reservation addReservation(Reservation reservation, Long customerId,Long busId,Integer seats)
			throws LoginException, CustomerNotFoundException,BusNotFoundException;

	public Reservation updateReservation(Reservation reservation, Long reservationId, Long customerId)
			throws LoginException, CustomerNotFoundException, ReservationNotFoundException;

	public String deleteReservation(Long reservationId, Long customerId)
			throws LoginException, CustomerNotFoundException, ReservationNotFoundException;

	public Reservation viewByIdReservation(Long reservationId, Long customerId)
			throws LoginException, CustomerNotFoundException, ReservationNotFoundException;

	public List<Reservation> allReservation(String key) throws AdminNotFoundException, ReservationNotFoundException;

//	public List<Reservation> viewByLocalDate(String key, LocalDate date)
//			throws ReservationNotFoundException, AdminNotFoundException;

}
