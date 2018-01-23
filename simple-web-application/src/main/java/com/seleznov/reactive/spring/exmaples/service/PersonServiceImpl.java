package com.seleznov.reactive.spring.exmaples.service;

import com.seleznov.reactive.spring.exmaples.model.Person;
import com.seleznov.reactive.spring.exmaples.repository.MongoReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.BaseStream;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private MongoReactiveRepository mongoReactiveRepository;

    @Override
    public Flux<Person> getPersonsFromFile(String filePath) {
        return Flux.using(() -> Files.lines(Paths.get(filePath)), Flux::fromStream, BaseStream::close)
                .map(Person::new)
                .flatMap(this::savePerson);

    }

    public Mono<Person> savePerson(Person person) {
        return mongoReactiveRepository.save(person);
    }


}
