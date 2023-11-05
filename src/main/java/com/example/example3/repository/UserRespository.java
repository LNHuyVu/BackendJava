package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.User;

public interface UserRespository extends JpaRepository<User, Long> {

}