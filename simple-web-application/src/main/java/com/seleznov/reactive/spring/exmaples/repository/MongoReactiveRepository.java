package com.seleznov.reactive.spring.exmaples.repository;


import com.seleznov.reactive.spring.exmaples.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface MongoReactiveRepository extends ReactiveCrudRepository<Person, String> {
}
