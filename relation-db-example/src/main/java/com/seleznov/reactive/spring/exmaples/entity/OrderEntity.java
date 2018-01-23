package com.seleznov.reactive.spring.exmaples.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<GoodsEntity> goodsEntities;

}
