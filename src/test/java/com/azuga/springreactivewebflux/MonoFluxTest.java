package com.azuga.springreactivewebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("Hello World")
                .then(Mono.error(new RuntimeException("Exception Occurred")))
                .log();
        monoString.subscribe(System.out::println, (e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("Prashant", "Rahul", "Bharath").log();
        fluxString.subscribe(System.out::println);
    }
}
