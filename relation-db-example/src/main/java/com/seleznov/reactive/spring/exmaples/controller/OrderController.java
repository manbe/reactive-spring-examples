package com.seleznov.reactive.spring.exmaples.controller;


import com.seleznov.reactive.spring.exmaples.model.Order;
import com.seleznov.reactive.spring.exmaples.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public Flux<Order> getOrders() {
//        Integer.valueOf("pppp");
        return orderService.getOrders();
    }

    @ExceptionHandler
    public void handleException(Exception e) {
        log.error("Error! {}", e);
    }
}
