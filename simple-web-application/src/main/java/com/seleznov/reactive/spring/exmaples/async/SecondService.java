package com.seleznov.reactive.spring.exmaples.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executor;

@Service
public class SecondService {

    @Autowired
    private Executor testExecutor;

    Mono<String> doSecondOperation() {
        return Mono.fromCallable(() -> {
            String threadName = Thread.currentThread().getName();
            return "second = " + threadName + ", ";
        }).publishOn(Schedulers.fromExecutor(testExecutor));
    }






































    Mono<String> doSecondOperation(String previousValue) {
        return Mono.fromCallable(() -> {
            String threadName = Thread.currentThread().getName();
            return previousValue + "second = " + threadName;
        }).subscribeOn(Schedulers.elastic());
    }

}
