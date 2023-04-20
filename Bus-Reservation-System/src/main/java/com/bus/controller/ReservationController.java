package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.entity.Reservation;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;
import com.bus.exception.ReservationNotFoundException;
import com.bus.service.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@PostMapping("add/{customerId}/{busId}/{seat}")
	public ResponseEntity<Reservation> addReservation_Handler(@RequestBody Reservation reservation,
			@PathVariable("customerId") Long customerId, @PathVariable("busId") Long busId,
			@PathVariable("seat") Integer seat) throws LoginException, CustomerNotFoundException, BusNotFoundException {
		return new ResponseEntity<Reservation>(reservationService.addReservation(reservation, customerId, busId, seat),
				HttpStatus.CREATED);
	}

	@PutMapping("update/{customerId}/{reservationId}")
	public ResponseEntity<Reservation> updateReservation_Handler(@RequestBody Reservation reservation,
			@PathVariable("customerId") Long customerId, @PathVariable("reservationId") Long reservationId)
			throws LoginException, CustomerNotFoundException ,ReservationNotFoundException{
		return new ResponseEntity<Reservation>(reservationService.updateReservation(reservation, reservationId, customerId),HttpStatus.CREATED);
	}
	@DeleteMapping("delete/{customerId}/{reservationId}")
	public ResponseEntity<String> deleteReservation_Handler(@PathVariable("customerId") Long customerId, @PathVariable("reservationId") Long reservationId)
			throws LoginException, CustomerNotFoundException ,ReservationNotFoundException{
		return new ResponseEntity<String>(reservationService.deleteReservation(reservationId, customerId),HttpStatus.CREATED);
	}
	@DeleteMapping("view/{customerId}/{reservationId}")
	public ResponseEntity<Reservation> viewReservation_Handler(@PathVariable("customerId") Long customerId, @PathVariable("reservationId") Long reservationId)
			throws LoginException, CustomerNotFoundException ,ReservationNotFoundException{
		return new ResponseEntity<Reservation>(reservationService.viewByIdReservation(reservationId, customerId),HttpStatus.CREATED);
	}
	

}
