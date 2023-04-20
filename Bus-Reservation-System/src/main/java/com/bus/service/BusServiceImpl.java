package com.bus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.BusDTO;
import com.bus.entity.Admin;
import com.bus.entity.AdminCurrentSession;
import com.bus.entity.Buses;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.repository.BusRepository;
import com.bus.repository.CurrentAdminSessionDao;

@Service
public class BusServiceImpl implements BusService{

	
	@Autowired
	private BusRepository busRepository;
	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;

	@Override
	public Buses addBus(Buses bus,String key) throws AdminNotFoundException, BusNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		return busRepository.save(bus);
	}

	@Override
	public BusDTO updateBus(BusDTO busDTO, Long busId,String key) throws AdminNotFoundException, BusNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		
		Optional<Buses> isOptional=busRepository.findById(busId);
		if(isOptional.isEmpty()) {
			throw new BusNotFoundException("No Bus is found with this id- "+busId);
			
		}
		Buses updateBus=isOptional.get();
		
		updateBus.setBusName(busDTO.getBusName());
		updateBus.setArrivalTime(busDTO.getArrivalTime());
		updateBus.setDriverName(busDTO.getDriverName());
		updateBus.setDepartureTime(busDTO.getDepartureTime());
		updateBus.setBusType(busDTO.getBusType());
		updateBus.setRouteTo(busDTO.getRouteTo());
		updateBus.setSeat(busDTO.getSeat());
		busRepository.save(updateBus);
		return busDTO;
		
		
	}

	@Override
	public String deleteBus(Long busId,String key) throws AdminNotFoundException, BusNotFoundException {
		if(key==null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		
		AdminCurrentSession admin=currentAdminSessionDao.findByAdminKey(key);
		if(admin==null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" +key);
		}
		
		Optional<Buses> isOptional=busRepository.findById(busId);
		if(isOptional.isEmpty()) {
			throw new BusNotFoundException("No Bus is found with this id- "+busId);
			
		}
		busRepository.delete(isOptional.get());
		return "Bus deleted successfully with busId- " + busId ;
	}

	@Override
	public Buses viewBusById(Long busId) throws AdminNotFoundException, BusNotFoundException {		
		Optional<Buses> isOptional=busRepository.findById(busId);
		if(isOptional.isEmpty()) {
			throw new BusNotFoundException("No Bus is found with this id- "+busId);
			
		}
		return isOptional.get();
	}

	@Override
	public List<Buses> viewByBusType(String busType) throws AdminNotFoundException, BusNotFoundException {
		
		List<Buses> buses=busRepository.findByBusType(busType);
		if(buses==null) {
			throw new BusNotFoundException("No bus if found with this type -"+ busType);
		}
		 return buses.stream().filter(b->b.getBusType().equals(busType)).collect(Collectors.toList());

	}

	@Override
	public List<Buses> viewAllBus() throws AdminNotFoundException, BusNotFoundException {
		return busRepository.findAll();
	}
	
	
}
