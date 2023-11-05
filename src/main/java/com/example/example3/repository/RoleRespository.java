package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Role;

public interface RoleRespository extends JpaRepository<Role, Long> {

}