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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.BusDTO;
import com.bus.dto.CustomerDTO;
import com.bus.entity.Buses;
import com.bus.entity.Customer;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.service.BusService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/buses")
public class busController {

	
	@Autowired
	private BusService busService;
	
	@PostMapping("/add/{key}")
	public ResponseEntity<Buses> postNewBus_Handler(@Valid @RequestBody BusDTO busDTO,@PathVariable("key") String key)  throws BusNotFoundException,AdminNotFoundException{
		return new ResponseEntity<Buses>(busService.addBus(busDTO,key),HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}/{key}")
	public ResponseEntity<BusDTO> updateBus_Handler(@Valid @RequestBody BusDTO busDTO, @PathVariable("key") String key,
			@PathVariable("id") Long id)  throws BusNotFoundException,AdminNotFoundException{
		return new ResponseEntity<BusDTO>(busService.updateBus(busDTO, id,key),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}/{key}")
	public ResponseEntity<String> deleteBus_Handler(@PathVariable("id") Long id,@PathVariable("key") String key)  throws BusNotFoundException,AdminNotFoundException{
		return new ResponseEntity<String>(busService.deleteBus(id,key),HttpStatus.OK);
	}
	@GetMapping("/views/{id}")
	public ResponseEntity<Buses> getBudById_Handler(@PathVariable("id") Long id)  throws BusNotFoundException,AdminNotFoundException{
		return new ResponseEntity<Buses>(busService.viewBusById(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewall")
	public ResponseEntity<List<Buses>> getAllBus_Handler()  throws BusNotFoundException,AdminNotFoundException{
		return new ResponseEntity<List<Buses>>(busService.viewAllBus(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/view/{type}")
	public ResponseEntity<List<Buses>> getBudByType_Handler(@PathVariable("type") String type)  throws BusNotFoundException,AdminNotFoundException{
		return new ResponseEntity<List<Buses>>(busService.viewByBusType(type),HttpStatus.ACCEPTED);
	}
	
}
