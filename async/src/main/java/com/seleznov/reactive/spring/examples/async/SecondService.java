package com.seleznov.reactive.spring.examples.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class SecondService {


    String doSecondOperation() {
        String threadName = Thread.currentThread().getName();
        return "second = " + threadName + ", ";
    }



















































//    @Async("asyncExecutor")
//    CompletableFuture<String> doSecondOperation() {
//        String threadName = Thread.currentThread().getName();
//        return CompletableFuture.completedFuture("second = " + threadName + ", ");
//    }

}
