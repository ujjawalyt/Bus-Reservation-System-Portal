package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.entity.Admin;
import com.bus.exception.AdminNotFoundException;
import com.bus.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/add")
	public ResponseEntity<Admin> insertNewAdminHandler(@RequestBody Admin admin) throws AdminNotFoundException {

		return new ResponseEntity<Admin>(adminService.saveNewAdminDetails(admin), HttpStatus.CREATED);
	}

	@PutMapping("/update/{key}")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin, @PathVariable("key") String key)
			throws AdminNotFoundException {

		return new ResponseEntity<Admin>(adminService.updateAdmin(admin,key), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{key}")
	public ResponseEntity<String> deleteAdminHandler(@PathVariable("key") String key) throws AdminNotFoundException {

		return new ResponseEntity<String>(adminService.deleteAdmin(key), HttpStatus.OK);
	}

}
