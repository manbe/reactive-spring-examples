package com.seleznov.reactive.spring.exmaples.model;

import com.seleznov.reactive.spring.exmaples.entity.OrderEntity;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Order {
    private Long id;

    private Set<Goods> goods;

    public static Order fromEntity(OrderEntity entity) {
        Order order = new Order();
        order.setId(entity.getId());
        order.setGoods(entity.getGoodsEntities().stream().map(Goods::fromEntity).collect(Collectors.toSet()));
        return order;
    }
}
