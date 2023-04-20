package com.bus.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.RouteDTO;
import com.bus.entity.Routes;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.RouteNotFoundException;
import com.bus.repository.RoutesRepository;
import com.bus.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RoutesRepository routesRepository;

	@Override
	public Routes addRoute(Routes routes) throws RouteNotFoundException, AdminNotFoundException {
		return routesRepository.save(routes);
	}

	@Override
	public RouteDTO updateRoute(RouteDTO routeDTO, Long routeId) throws RouteNotFoundException, AdminNotFoundException {
		Optional<Routes> isOptional=routesRepository.findById(routeId);
		if(isOptional.isEmpty()) {
			throw new RouteNotFoundException("No Route is found with this id- "+ routeId);
			
		}
		Routes updateRoute=isOptional.get();
		updateRoute.setDistance(routeDTO.getDistance());
		updateRoute.setStartPoint(routeDTO.getStartPoint());
		updateRoute.setEndPoint(routeDTO.getEndPoint());
		
		routesRepository.save(updateRoute);
		return routeDTO;
		
	}

	@Override
	public String deleteRoute(Long routeId) throws AdminNotFoundException, RouteNotFoundException {
		Optional<Routes> isOptional=routesRepository.findById(routeId);
		if(isOptional.isEmpty()) {
			throw new RouteNotFoundException("No Route is found with this id- "+ routeId);
			
		}
		routesRepository.delete(isOptional.get());
		return "Route is deleted successfully from database with this id- " +routeId ;
	}

	@Override
	public List<Routes> viewAllRoutes() throws AdminNotFoundException, RouteNotFoundException {
		return routesRepository.findAll();
	}

	@Override
	public Routes routeById(Long routeId) throws AdminNotFoundException, RouteNotFoundException {
		Optional<Routes> isOptional=routesRepository.findById(routeId);
		if(isOptional.isEmpty()) {
			throw new RouteNotFoundException("No Route is found with this id- "+ routeId);
			
		}
		return isOptional.get();
	}
	
	
}
