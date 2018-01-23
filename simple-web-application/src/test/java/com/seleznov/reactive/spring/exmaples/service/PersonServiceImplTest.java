package com.seleznov.reactive.spring.exmaples.service;

import com.seleznov.reactive.spring.exmaples.model.Person;
import com.seleznov.reactive.spring.exmaples.repository.MongoReactiveRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private MongoReactiveRepository mongoReactiveRepository;

    @Test
    public void shouldGetPersonsFromFile() throws Exception {
        //given
        String path = this.getClass().getResource("/persons.csv").getPath();
        Person bart = new Person("Bart");
        Person lisa = new Person("Lisa");
        when(mongoReactiveRepository.save(bart)).thenReturn(Mono.just(bart));
        when(mongoReactiveRepository.save(lisa)).thenReturn(Mono.just(lisa));

        //when
        Flux<Person> persons = personService.getPersonsFromFile(path);

        //then
        StepVerifier.create(persons)
                .expectNext(bart)
                .expectNext(lisa)
                .expectComplete()
                .verify();

        verify(mongoReactiveRepository).save(bart);
        verify(mongoReactiveRepository).save(lisa);
    }

}