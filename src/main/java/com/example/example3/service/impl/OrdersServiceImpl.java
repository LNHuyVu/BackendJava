package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.Orders;
import com.example.example3.repository.OrdersRespository;
import com.example.example3.service.OrdersService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private OrdersRespository ordersRespository;

    @Override
    public Orders createOrders(Orders orders) {
        return ordersRespository.save(orders);
    }

    @Override
    public Orders getOrdersById(Long ordersId) {
        Optional<Orders> optionalOrders = ordersRespository.findById(ordersId);
        return optionalOrders.get();
    }

    @Override
    public List<Orders> getAllOrderss() {
        return ordersRespository.findAll();
    }

    @Override
    public Orders updateOrders(Orders orders) {
        Orders existingOrders = ordersRespository.findById(orders.getId()).get();
        existingOrders.setFullname(orders.getFullname());
        existingOrders.setEmail(orders.getEmail());
        existingOrders.setPhone_number(orders.getPhone_number());
        existingOrders.setAddress(orders.getAddress());
        existingOrders.setNote(orders.getNote());
        existingOrders.setOrder_date(orders.getOrder_date());
        existingOrders.setStatus(orders.getStatus());
        existingOrders.setTotal_money(orders.getTotal_money());

        Orders updatedOrders = ordersRespository.save(existingOrders);
        return updatedOrders;
    }

    @Override
    public void deleteOrders(Long ordersId) {
        ordersRespository.deleteById(ordersId);
    }
}
