package com.seleznov.reactive.spring.exmaples.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executor;

@Service
public class FirstService {

    @Autowired
    private Executor testExecutor;

    Mono<String> doFirstOperation() {
        return Mono.fromCallable(() -> {
            String threadName = Thread.currentThread().getName();
            return "first = " + threadName + ", ";
        }).publishOn(Schedulers.fromExecutor(testExecutor));
    }



























    Mono<String> doFirstOperation(String previousValue) {
        return Mono.fromCallable(() -> {
            String threadName = Thread.currentThread().getName();
            return "first = " + threadName + ", ";
        }).subscribeOn(Schedulers.fromExecutor(testExecutor));
    }
}




















