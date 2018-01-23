package com.seleznov.reactive.spring.exmaples.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Callable;

@Service
public class BlockingWrapperService {

    public <T> Mono<T> async(Callable<T> callable, Scheduler scheduler) {
         return Mono.fromCallable(callable)
                 .publishOn(scheduler)
                 .publishOn(Schedulers.elastic());
    }

    public void async(Runnable runnable, Scheduler scheduler) {
        Mono.fromRunnable(runnable).publishOn(scheduler).subscribe();
    }
}
