package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.OrderDetail;

public interface OrderDetailRespository extends JpaRepository<OrderDetail, Long> {

}