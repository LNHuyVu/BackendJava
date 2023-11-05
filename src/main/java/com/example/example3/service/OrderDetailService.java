package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.OrderDetail;

public interface OrderDetailService {

    public OrderDetail createOrderDetail(OrderDetail orderDetail);

    public OrderDetail getOrderDetailById(Long orderDetailId);

    public List<OrderDetail> getAllOrderDetails();

    public OrderDetail updateOrderDetail(OrderDetail orderDetail);

    public void deleteOrderDetail(Long orderDetailId);
}