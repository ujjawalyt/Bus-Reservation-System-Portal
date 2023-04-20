package com.bus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.entity.Admin;
import com.bus.entity.AdminCurrentSession;
import com.bus.exception.AdminNotFoundException;
import com.bus.repository.AdminRepository;
import com.bus.repository.CurrentAdminSessionDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;

	@Override
	public Admin saveNewAdminDetails(Admin admin) throws AdminNotFoundException {
		Admin admins = adminRepository.findByUsername(admin.getUsername());

		if (admins == null) {
			return adminRepository.save(admin);
		} else {
			throw new AdminNotFoundException("Admin with this username is already present");
		}
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminNotFoundException {
		if (key == null) {
			throw new AdminNotFoundException("Key Should not be null");
		}
		AdminCurrentSession isadmin = currentAdminSessionDao.findByAdminKey(key);
		if (isadmin == null) {
			throw new AdminNotFoundException("Admin is not logged in with this key -" + key);
		}
		Optional<Admin> existingAdmin = adminRepository.findById(isadmin.getAdminId());
		if (existingAdmin.isPresent()) {
			Admin updatedAdmin = existingAdmin.get();
			updatedAdmin.setEmail(admin.getEmail());
			updatedAdmin.setName(admin.getName());
			updatedAdmin.setPassword(admin.getPassword());
			updatedAdmin.setUsername(admin.getUsername());
			adminRepository.save(updatedAdmin);
		}

		return admin;

	}

	@Override
	public String deleteAdmin(String key) throws AdminNotFoundException {
		AdminCurrentSession isPresent = currentAdminSessionDao.findByAdminKey(key);

		if (isPresent == null) {
			throw new AdminNotFoundException("Admin not present with this key" + key);
		}

		Optional<Admin> existingAdmin = adminRepository.findById(isPresent.getAdminId());
		if (existingAdmin.isPresent()) {

			adminRepository.delete(existingAdmin.get());

		}
		return "Admin with this key is Successfully Deleted";

	}

}
