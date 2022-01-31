package com.netcracker.edu.manager.integration.rest.controller;

import com.netcracker.edu.manager.integration.rest.model.SellOrder;
import com.netcracker.edu.manager.integration.rest.model.SupplyOrder;
import com.netcracker.edu.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/supply")
    public void supply(@RequestBody SupplyOrder order) {
        orderService.supply(order);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/sell")
    public void sell(@RequestBody SellOrder order) {
        orderService.sell(order);
    }

    @ExceptionHandler({ConnectException.class})
    public ResponseEntity handleException(Exception exception) {
        Object errorBody = "Failed connection: " + exception.getMessage();
        return new ResponseEntity(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
