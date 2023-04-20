package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.AdminLoginDto;
import com.bus.exception.AdminNotFoundException;
import com.bus.service.AdminLoginService;


@RestController
@RequestMapping("/admin")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> adminLoginHandler(@RequestBody  AdminLoginDto adminLoginDto) throws AdminNotFoundException{
		
		return new  ResponseEntity<String>(adminLoginService.logIntoAccount(adminLoginDto) ,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> adminLogoutHandler(String key) throws AdminNotFoundException{
		
		return new ResponseEntity<String>(adminLoginService.logoutFromAccount(key),HttpStatus.OK);
	}
}
