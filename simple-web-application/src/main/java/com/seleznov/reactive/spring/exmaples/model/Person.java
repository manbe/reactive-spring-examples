package com.seleznov.reactive.spring.exmaples.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Person {

    private String id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
