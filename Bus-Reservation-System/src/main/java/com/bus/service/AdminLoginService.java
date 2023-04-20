package com.bus.service;

import org.springframework.stereotype.Service;

import com.bus.dto.AdminLoginDto;
import com.bus.exception.AdminNotFoundException;

@Service
public interface AdminLoginService {

    public String logIntoAccount(AdminLoginDto adminLoginDto) throws AdminNotFoundException;
	public String logoutFromAccount(String key) throws AdminNotFoundException;
}
