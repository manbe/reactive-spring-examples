package com.seleznov.reactive.spring.exmaples.model;

import com.seleznov.reactive.spring.exmaples.entity.GoodsEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Goods {

    private Long id;
    private String name;

    public static Goods fromEntity(GoodsEntity entity) {
        Goods goods = new Goods();
        goods.setId(entity.getId());
        goods.setName(entity.getName());
        return goods;
    }
}
