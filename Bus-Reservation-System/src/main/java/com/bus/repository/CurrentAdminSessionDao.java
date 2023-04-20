package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.AdminCurrentSession;

public interface CurrentAdminSessionDao  extends JpaRepository<AdminCurrentSession, Long>{

	public AdminCurrentSession findByAdminKey(String Key);
}
