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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.entity.Admin;
import com.bus.entity.Reservation;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;
import com.bus.exception.ReservationNotFoundException;
import com.bus.service.AdminService;
import com.bus.service.ReservationService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/add")
	public ResponseEntity<Admin> insertNewAdminHandler(@Valid @RequestBody Admin admin) throws AdminNotFoundException {

		return new ResponseEntity<Admin>(adminService.saveNewAdminDetails(admin), HttpStatus.CREATED);
	}

	@PutMapping("/update/{key}")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin, @PathVariable("key") String key)
			throws AdminNotFoundException {

		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, key), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{key}")
	public ResponseEntity<String> deleteAdminHandler(@PathVariable("key") String key) throws AdminNotFoundException {

		return new ResponseEntity<String>(adminService.deleteAdmin(key), HttpStatus.OK);
	}

	@GetMapping("/reservation/view/{key}")
	public ResponseEntity<List<Reservation>> viewAllReservation_Handler(@PathVariable("key") String key)
			throws LoginException, AdminNotFoundException, ReservationNotFoundException {
		return new ResponseEntity<List<Reservation>>(reservationService.allReservation(key), HttpStatus.OK);
	}

}
