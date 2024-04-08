package ir.curlymind.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02Error {
    @Test
    public void test() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Object> error = Flux.error(new RuntimeException("oops"));
        Flux<Object> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1)
                .expectNext(2, 3)
//                .expectError();
//                .expectError(RuntimeException.class);
                .expectErrorMessage("oops");
    }
}
