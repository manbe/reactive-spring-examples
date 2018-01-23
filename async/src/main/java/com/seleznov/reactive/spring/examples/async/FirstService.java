package com.seleznov.reactive.spring.examples.async;

import org.springframework.stereotype.Service;

@Service
public class FirstService {

    String doFirstOperation() {
        String threadName = Thread.currentThread().getName();
        return "first = " + threadName + ", ";
    }
























































//    @Async("asyncExecutor")
//    CompletableFuture<String> doFirstOperation() {
//        String threadName = Thread.currentThread().getName();
//        return CompletableFuture.completedFuture("first = " + threadName + ", ");
//    }
}




















