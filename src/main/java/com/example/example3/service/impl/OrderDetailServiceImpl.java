package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.OrderDetail;
import com.example.example3.repository.OrderDetailRespository;
import com.example.example3.service.OrderDetailService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRespository orderDetailRespository;

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRespository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(Long orderDetailId) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRespository.findById(orderDetailId);
        return optionalOrderDetail.get();
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRespository.findAll();
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        OrderDetail existingOrderDetail = orderDetailRespository.findById(orderDetail.getId()).get();
        existingOrderDetail.setPrice(orderDetail.getPrice());
        existingOrderDetail.setNum(orderDetail.getNum());
        existingOrderDetail.setTotal_money(orderDetail.getTotal_money());

        OrderDetail updatedOrderDetail = orderDetailRespository.save(existingOrderDetail);
        return updatedOrderDetail;
    }

    @Override
    public void deleteOrderDetail(Long orderDetailId) {
        orderDetailRespository.deleteById(orderDetailId);
    }
}
