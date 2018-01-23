package com.seleznov.reactive.spring.exmaples.service;

import com.seleznov.reactive.spring.exmaples.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Mono<Person> savePerson(Person person);

    Flux<Person> getPersonsFromFile(String filePath);
}
