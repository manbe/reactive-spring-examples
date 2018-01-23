package com.seleznov.reactive.spring.examples.async;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class TestController {

    @Autowired
    private FirstService firstService;

    @Autowired
    private SecondService secondService;

    @GetMapping("/test")
    public String test() throws ExecutionException, InterruptedException {
        String firstResult = firstService.doFirstOperation();
        String secondResult = secondService.doSecondOperation();

        return firstResult + secondResult;
    }









































//    @GetMapping("/test")
//    public String test() throws ExecutionException, InterruptedException {
//        String handlerThreadName = "handler = " +Thread.currentThread().getName() + ", ";
//
//        CompletableFuture<String> firstOperationFutureResult = firstService.doFirstOperation();
//        CompletableFuture<String> secondOperationFutureResult = secondService.doSecondOperation();
//
//        return handlerThreadName + firstOperationFutureResult.get() + secondOperationFutureResult.get();
//    }



}
