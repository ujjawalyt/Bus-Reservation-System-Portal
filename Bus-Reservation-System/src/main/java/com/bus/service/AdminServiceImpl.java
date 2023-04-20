package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.entity.Admin;
import com.bus.exception.AdminNotFoundException;
import com.bus.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private  AdminRepository adminRepository;
	
	@Override
	public Admin saveNewAdminDetails(Admin admin) throws AdminNotFoundException {
		Admin admins = adminRepository.findByUsername(admin.getUsername());
		 
		 if(admins==null) {
			return adminRepository.save(admin);
		 }else {
			 throw new AdminNotFoundException("Admin with this username is already present");
		 }
	}

	
}
