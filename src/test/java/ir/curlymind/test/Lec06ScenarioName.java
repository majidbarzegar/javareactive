package ir.curlymind.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class Lec06ScenarioName {
    @Test
    public void test1() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        StepVerifierOptions scenarioName = StepVerifierOptions.create().scenarioName("first test");
        StepVerifier
                .create(just, scenarioName)
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    public void test2() {
        Flux<Integer> just = Flux.just(1, 5, 3);
        StepVerifier.create(just)
                .expectNext(1)
                .as("1-test")
                .expectNext(2)
                .as("2-test")
                .expectNext(3)
                .as("3-test")
                .verifyComplete();
    }
}
