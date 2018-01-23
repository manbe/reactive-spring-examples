package com.seleznov.reactive.spring.exmaples.service;

import org.springframework.stereotype.Service;

@Service
public class MailService {

    public void sendEmail(String message) {
        System.out.println("==============MAIL=================");
        System.out.println("Thread= "+ Thread.currentThread().getName());
        System.out.println("message = " + message);
    }
}
