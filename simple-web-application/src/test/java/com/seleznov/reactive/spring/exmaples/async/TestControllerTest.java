package com.seleznov.reactive.spring.exmaples.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCreatingNewThreads() {
        webTestClient.get().uri("/test")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(respnse ->
                        assertThat(respnse.getResponseBody(), containsString("handler = reactor-http-nio-6")));
    }

}