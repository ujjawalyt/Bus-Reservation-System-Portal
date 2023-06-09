package com.bus.service;

import java.util.List;

import com.bus.dto.BusDTO;
import com.bus.entity.Buses;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;

public interface BusService {

	public Buses addBus(BusDTO busDTO, String key) throws AdminNotFoundException, BusNotFoundException;

	public BusDTO updateBus(BusDTO busDTO, Long busId, String key) throws AdminNotFoundException, BusNotFoundException;

	public String deleteBus(Long busId, String key) throws AdminNotFoundException, BusNotFoundException;

	public Buses viewBusById(Long busId) throws AdminNotFoundException, BusNotFoundException;

	public List<Buses> viewByBusType(String busType) throws AdminNotFoundException, BusNotFoundException;

	public List<Buses> viewAllBus() throws AdminNotFoundException, BusNotFoundException;

}
