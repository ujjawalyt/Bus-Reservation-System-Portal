package com.bus.controller;

import java.util.List;

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

import com.bus.dto.RouteDTO;
import com.bus.entity.Routes;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.RouteNotFoundException;
import com.bus.service.RouteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/route")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@PostMapping("/add/{key}/{id}")
	public ResponseEntity<Routes> postNewRoute_Handler(@RequestBody Routes Routes, @PathVariable("key") String key,@PathVariable("id") Long id)
			throws RouteNotFoundException, AdminNotFoundException,BusNotFoundException {
		return new ResponseEntity<Routes>(routeService.addRoute(Routes, key,id), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}/{key}")
	public ResponseEntity<RouteDTO> updateRoute_Handler(@RequestBody RouteDTO routeDTO, @PathVariable("key") String key,
			@PathVariable("id") Long id) throws RouteNotFoundException, AdminNotFoundException {
		return new ResponseEntity<RouteDTO>(routeService.updateRoute(routeDTO, id, key), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}/{key}")
	public ResponseEntity<String> deleteRoute_Handler(@PathVariable("id") Long id, @PathVariable("key") String key)
			throws RouteNotFoundException, AdminNotFoundException {
		return new ResponseEntity<String>(routeService.deleteRoute(id, key), HttpStatus.OK);
	}

	@GetMapping("/views/{id}")
	public ResponseEntity<Routes> getRouteById_Handler(@PathVariable("id") Long id)
			throws RouteNotFoundException, AdminNotFoundException {
		return new ResponseEntity<Routes>(routeService.routeById(id), HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<List<Routes>> getAllRoute_Handler() throws RouteNotFoundException, AdminNotFoundException {
		return new ResponseEntity<List<Routes>>(routeService.viewAllRoutes(), HttpStatus.ACCEPTED);
	}

}
