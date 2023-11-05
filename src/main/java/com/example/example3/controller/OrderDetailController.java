package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.OrderDetail;
import com.example.example3.service.OrderDetailService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/order-detail")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail savedOrderDetail = orderDetailService.createOrderDetail(orderDetail);
        return new ResponseEntity<>(savedOrderDetail, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable("id") Long orderDetailId) {
        OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> OrderDetails = orderDetailService.getAllOrderDetails();
        return new ResponseEntity<>(OrderDetails, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable("id") Long orderDetailId,
            @RequestBody OrderDetail OrderDetail) {
        OrderDetail.setId(orderDetailId);
        OrderDetail upOrderDetail = orderDetailService.updateOrderDetail(OrderDetail);
        return new ResponseEntity<>(upOrderDetail, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable("id") Long orderDetailId) {
        orderDetailService.deleteOrderDetail(orderDetailId);
        return new ResponseEntity<>("OrderDetail delete OK", HttpStatus.OK);
    }
}