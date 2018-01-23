package com.seleznov.reactive.spring.exmaples.controller;


import com.seleznov.reactive.spring.exmaples.model.Person;
import com.seleznov.reactive.spring.exmaples.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/person", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    Flux<Person> getPerson(@RequestParam String filePath) {
        return personService.getPersonsFromFile(filePath)
                .delayElements(Duration.of(1, ChronoUnit.SECONDS));
    }

    @PostMapping("/person")
    Mono<Person> createPerson(Person person) {
        return personService.savePerson(person);
    }

}
