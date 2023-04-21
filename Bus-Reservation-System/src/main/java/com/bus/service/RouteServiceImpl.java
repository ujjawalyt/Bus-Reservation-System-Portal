package com.bus.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.RouteDTO;
import com.bus.entity.AdminCurrentSession;
import com.bus.entity.Buses;
import com.bus.entity.Routes;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.RouteNotFoundException;
import com.bus.repository.BusRepository;
import com.bus.repository.CurrentAdminSessionDao;
import com.bus.repository.RoutesRepository;
import com.bus.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RoutesRepository routesRepository;
	
	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public Routes addRoute(Routes routes,String key, Long busId) throws RouteNotFoundException, AdminNotFoundException, BusNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		Optional<Buses> bus = busRepository.findById(busId);
	    if(bus.isEmpty()) {
	        throw new BusNotFoundException("Bus not found with id - " + busId);
	    }
	    routes.getBusList().add(bus.get());
		return routesRepository.save(routes);
	}

	@Override
	public RouteDTO updateRoute(RouteDTO routeDTO, Long routeId,String key) throws RouteNotFoundException, AdminNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		
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
	public String deleteRoute(Long routeId,String key) throws AdminNotFoundException, RouteNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		
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
