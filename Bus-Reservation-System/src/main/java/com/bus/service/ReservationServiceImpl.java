package com.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.entity.Admin;
import com.bus.entity.AdminCurrentSession;
import com.bus.entity.Buses;
import com.bus.entity.CurrentCustomerSession;
import com.bus.entity.Customer;
import com.bus.entity.Reservation;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.BusNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.LoginException;
import com.bus.exception.ReservationNotFoundException;
import com.bus.repository.BusRepository;
import com.bus.repository.CurrentAdminSessionDao;
import com.bus.repository.CurrentCustomerSessionDao;
import com.bus.repository.CustomerRepository;
import com.bus.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;
	@Autowired
	private CurrentCustomerSessionDao currentCustomerSessionDao;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BusRepository busRepository;

	@Override
	public Reservation addReservation(Reservation reservation, Long customerId, Long busId, Integer seat)
			throws LoginException, CustomerNotFoundException, BusNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			Customer exsCustomer = customer.get();
			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(exsCustomer.getCustomerId());

			if (isCurrent.isPresent()) {
				Optional<Buses> isBus = busRepository.findById(busId);
				if (isBus.isPresent()) {
					Integer remainingSeats = isBus.get().getAvailableSeats() - seat;
					if (remainingSeats < 0) {
						throw new BusNotFoundException("Not enough seats available on the bus.");
					}

					isBus.get().setAvailableSeats(remainingSeats);
					busRepository.save(isBus.get());

					if (reservation.getBus() == null) {
						Buses bus = isBus.get();
						reservation.setBus(bus);
					}
       
					
//					Reservation res = reservation;
//					res = res =reservationRepository.save(res);
//					exsCustomer.setReservation(reservation); 
//					customerRepository.save(exsCustomer);
//					return res;
				
					   reservation.setCustomer(exsCustomer);

		                Reservation res = reservationRepository.save(reservation);
		                return res;
					
//					Reservation res =reservationRepository.save(reservation);
//					exsCustomer.setReservation(res);
//					customerRepository.save(exsCustomer);
//					return res;

				} else {
					throw new BusNotFoundException("No bus is present with this id");
				}

			} else {
				throw new LoginException("Customer is not logged in..");
			}

		} else {
			throw new CustomerNotFoundException("No customer is found with this id -" + customerId);
		}
	}

	@Override
	public Reservation updateReservation(Reservation reservation, Long reservationId, Long customerId)
			throws LoginException, CustomerNotFoundException, ReservationNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			Customer exsCustomer = customer.get();
			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(exsCustomer.getCustomerId());
			if (isCurrent.isPresent()) {
				Optional<Reservation> isReservation = reservationRepository.findById(reservationId);
				if (isReservation.isPresent()) {
					Reservation updateReservation=isReservation.get();
					
					updateReservation.setDestination(reservation.getDestination());
					updateReservation.setReservationDate(reservation.getReservationDate());
					updateReservation.setDestination(reservation.getDestination());
					updateReservation.setReservationTime(reservation.getReservationTime());
					updateReservation.setReservationType(reservation.getReservationType());
					updateReservation.setSource(reservation.getSource());
					updateReservation.setStatus(reservation.getStatus());
					
					reservationRepository.save(updateReservation);
					return updateReservation;
					
				}else {
					throw new ReservationNotFoundException("No reservation is found with this id"+ reservationId);
				}
			}else {
					throw new LoginException("Customer is not logged in "+customerId);
				}
			
		}else {
			throw new CustomerNotFoundException("Customer is not found with this id-- "+customerId);
		}
	}

	@Override
	public String deleteReservation(Long reservationId, Long customerId)
			throws LoginException, CustomerNotFoundException, ReservationNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			Customer exsCustomer = customer.get();
			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(exsCustomer.getCustomerId());
			if (isCurrent.isPresent()) {
				Optional<Reservation> isReservation = reservationRepository.findById(reservationId);
				if (isReservation.isPresent()) {
					reservationRepository.delete(isReservation.get());
					return "Canceelled SuccessFully ";
					
				}else {
					throw new ReservationNotFoundException("No reservation is found with this id"+ reservationId);
				}
			}else {
					throw new LoginException("Customer is not logged in "+customerId);
				}
			
		}else {
			throw new CustomerNotFoundException("Customer is not found with this id-- "+customerId);
		}
	}

	@Override
	public Reservation viewByIdReservation(Long reservationId, Long customerId)
			throws LoginException, CustomerNotFoundException, ReservationNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			Customer exsCustomer = customer.get();
			Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao
					.findById(exsCustomer.getCustomerId());
			if (isCurrent.isPresent()) {
				Optional<Reservation> isReservation = reservationRepository.findById(reservationId);
				if (isReservation.isPresent()) {
				return isReservation.get();
				}else {
					throw new ReservationNotFoundException("No reservation is found with this id"+ reservationId);
				}
			}else {
					throw new LoginException("Customer is not logged in "+customerId);
				}
			
		}else {
			throw new CustomerNotFoundException("Customer is not found with this id-- "+customerId);
		}
	}

	@Override
	public List<Reservation> allReservation(String key) throws AdminNotFoundException, ReservationNotFoundException {
		AdminCurrentSession isAdmin=currentAdminSessionDao.findByAdminKey(key);
		if(isAdmin!=null) {
			List<Reservation>list= reservationRepository.findAll();
			if(list.size()==0) {
				throw new ReservationNotFoundException("No reservation found");
			}
			return list;
		}else {
			throw new AdminNotFoundException("No Admin is logged in");
		}
		
	}

}
