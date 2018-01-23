package com.seleznov.reactive.spring.exmaples.service;

import com.seleznov.reactive.spring.exmaples.model.Order;
import com.seleznov.reactive.spring.exmaples.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderBlockingService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Set<Order> getOrders() {
        Integer.valueOf("lol");
        return orderRepository.findAll().stream()
                .map(Order::fromEntity).collect(Collectors.toSet());
    }
}
