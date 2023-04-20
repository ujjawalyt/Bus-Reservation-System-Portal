package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

public Admin findByUsername(String username);

}
