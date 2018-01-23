package com.seleznov.reactive.spring.exmaples.async;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class FirstServiceTest {

    @Test
    public void publishOnTwice() {
        Mono<Integer> mono = Mono.just(0);
        Mono<Integer> mono1 = assertThread(mono.publishOn(Schedulers.newSingle("one")), "one");
        Mono<Integer> mono2 = assertThread(mono1.publishOn(Schedulers.newSingle("two")), "two");
        mono2.block(Duration.ofSeconds(1));
    }
    @Test
    public void subscribeOnTwice() {
        Mono<Integer> mono = Mono.just(0);
        Mono<Integer> mono1 = assertThread(mono.subscribeOn(Schedulers.newSingle("one")), "one");
        Mono<Integer> mono2 = assertThread(mono1.subscribeOn(Schedulers.newSingle("two")), "one");
        Mono<Integer> mono3 = assertThread(mono1.subscribeOn(Schedulers.newSingle("three")), "three");
        mono3.block(Duration.ofSeconds(1));
    }

    static <T> Mono<T> assertThread(Mono<T> mono, String name) {
        return mono.doOnNext(
                e -> assertThat(Thread.currentThread().getName(), startsWith(name))
        );
    }

}