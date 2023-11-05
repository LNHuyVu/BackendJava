package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.Orders;

public interface OrdersService {

    public Orders createOrders(Orders orders);

    public Orders getOrdersById(Long ordersId);

    public List<Orders> getAllOrderss();

    public Orders updateOrders(Orders orders);

    public void deleteOrders(Long ordersId);
}