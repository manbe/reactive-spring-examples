package com.seleznov.reactive.spring.exmaples.repository;

import com.seleznov.reactive.spring.exmaples.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
