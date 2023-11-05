package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Orders;

public interface OrdersRespository extends JpaRepository<Orders, Long> {

}