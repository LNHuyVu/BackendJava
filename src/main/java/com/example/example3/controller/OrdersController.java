package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Orders;
import com.example.example3.service.OrdersService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrdersController {
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
        Orders savedOrders = ordersService.createOrders(orders);
        return new ResponseEntity<>(savedOrders, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable("id") Long ordersId) {
        Orders orders = ordersService.getOrdersById(ordersId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrderss() {
        List<Orders> Orderss = ordersService.getAllOrderss();
        return new ResponseEntity<>(Orderss, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable("id") Long ordersId,
            @RequestBody Orders Orders) {
        Orders.setId(ordersId);
        Orders upOrders = ordersService.updateOrders(Orders);
        return new ResponseEntity<>(upOrders, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrders(@PathVariable("id") Long ordersId) {
        ordersService.deleteOrders(ordersId);
        return new ResponseEntity<>("Orders delete OK", HttpStatus.OK);
    }
}