package com.bus.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bus.dto.AdminLoginDto;
import com.bus.entity.Admin;
import com.bus.entity.AdminCurrentSession;
import com.bus.exception.AdminNotFoundException;
import com.bus.repository.AdminRepository;
import com.bus.repository.CurrentAdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String logIntoAccount(AdminLoginDto adminLoginDto) throws AdminNotFoundException {
		
		Admin admin = adminRepository.findByUsername(adminLoginDto.getUsername());
		if(admin==null) {
			throw new AdminNotFoundException("Admin not present with this usename");
		}
		Optional<AdminCurrentSession> isValid = currentAdminSessionDao.findById(admin.getAdminId());
		
		if(isValid.isPresent()) {
			throw new AdminNotFoundException("admin with this username is already present");
		}
		if(admin.getPassword().equals(adminLoginDto.getPassword())) {
			String key = RandomString.make(4);
			AdminCurrentSession adminCurrentSession = new AdminCurrentSession(admin.getAdminId(),key, LocalDateTime.now());
			currentAdminSessionDao.save(adminCurrentSession);
			return "Loggin Successfull with this key :" + key;
		}else {
			throw new AdminNotFoundException("password Incorrect...");
		}
		
	}

	@Override
	public String logoutFromAccount(String key) throws AdminNotFoundException {
		
		AdminCurrentSession adminCurrentSession = currentAdminSessionDao.findByAdminKey(key);
		if(adminCurrentSession==null) {
			throw new AdminNotFoundException("Incorrect key..");
			
		}
		currentAdminSessionDao.delete(adminCurrentSession);
		return "Logout From Account..";
	}
	
}
