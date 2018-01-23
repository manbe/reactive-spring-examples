package com.seleznov.reactive.spring.exmaples.service;

import com.seleznov.reactive.spring.exmaples.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderBlockingService orderBlockingService;

    @Autowired
    private BlockingWrapperService blockingWrapperService;

    @Autowired
    private MailService mailService;

    public Flux<Order> getOrders() {
        blockingWrapperService.async(() -> mailService.sendEmail("Ping"), Schedulers.newParallel("mail"));
        return blockingWrapperService.async(() -> orderBlockingService.getOrders(), Schedulers.newParallel("db"))
                .flatMapIterable(Function.identity());
    }


}
