package com.bus.service;

import java.util.List;

import com.bus.dto.RouteDTO;
import com.bus.entity.Routes;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.RouteNotFoundException;

public interface RouteService {

	public Routes addRoute(Routes routes, String key, Long busId) 
			throws RouteNotFoundException, AdminNotFoundException, BusNotFoundException;

	public RouteDTO updateRoute(RouteDTO routeDTO, Long routeId, String key)
			throws RouteNotFoundException, AdminNotFoundException;

	public String deleteRoute(Long routeId, String key) throws AdminNotFoundException, RouteNotFoundException;

	public List<Routes> viewAllRoutes() throws AdminNotFoundException, RouteNotFoundException;

	public Routes routeById(Long routeId) throws AdminNotFoundException, RouteNotFoundException;
}
