package com.seleznov.reactive.spring.exmaples.async;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @Autowired
    private FirstService firstService;

    @Autowired
    private SecondService secondService;

    @GetMapping("/test")
    Mono<String> test() {
        String handlerThreadName = "handler = " + Thread.currentThread().getName() + ", ";

        Mono<String> firstOperationFutureResult = firstService.doFirstOperation();
        Mono<String> secondOperationFutureResult = secondService.doSecondOperation();

        return Mono.zip(results -> handlerThreadName + results[0] + results[1],
                firstOperationFutureResult, secondOperationFutureResult);
    }





































    @GetMapping("/chainTest")
    Mono<String> chainTest() {
        String handlerThreadName = "handler = " + Thread.currentThread().getName() + ", ";

        return firstService.doFirstOperation(handlerThreadName)
                .flatMap(result -> secondService.doSecondOperation(result));
    }


}
