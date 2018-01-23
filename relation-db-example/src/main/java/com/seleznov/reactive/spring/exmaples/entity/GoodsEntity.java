package com.seleznov.reactive.spring.exmaples.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
@Data
public class GoodsEntity {

    @Id
    private Long id;

    private String name;
}
