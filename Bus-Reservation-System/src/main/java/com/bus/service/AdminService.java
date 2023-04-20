package com.bus.service;

import org.springframework.stereotype.Service;

import com.bus.entity.Admin;
import com.bus.exception.AdminNotFoundException;

@Service
public interface AdminService {

	public Admin saveNewAdminDetails(Admin admin) throws AdminNotFoundException;
	
	public Admin updateAdmin(Admin admin,String key) throws AdminNotFoundException;
	
	public String deleteAdmin(String key) throws AdminNotFoundException;
	
	
}
