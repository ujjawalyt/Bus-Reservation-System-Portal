package com.bus.service;

import java.util.List;

import com.bus.dao.RouteDTO;
import com.bus.entity.Routes;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.RouteNotFoundException;

public interface RouteService {

	
	public Routes addRoute(Routes routes) throws RouteNotFoundException,AdminNotFoundException;
	
	public RouteDTO updateRoute(RouteDTO routeDTO, Long routeId) throws RouteNotFoundException,AdminNotFoundException;

	public String deleteRoute(Long routeId) throws AdminNotFoundException,RouteNotFoundException;
	
	public List<Routes> viewAllRoutes() throws AdminNotFoundException, RouteNotFoundException;
	
	public Routes routeById(Long routeId) throws AdminNotFoundException,RouteNotFoundException;
}
