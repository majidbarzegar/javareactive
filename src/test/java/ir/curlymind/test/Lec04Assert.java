package ir.curlymind.test;

import ir.curlymind.javareactive.sec09batching.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec04Assert {
    @Test
    public void test1() {
        Mono<BookOrder> mono = Mono.fromSupplier(() -> new BookOrder());
        StepVerifier.create(mono)
                .assertNext(bookOrder -> Assertions.assertNotNull(bookOrder.getAuthor()))
                .verifyComplete();
    }

    @Test
    public void test2() {
        Mono<BookOrder> mono = Mono
                .fromSupplier(() -> new BookOrder())
                .delayElement(Duration.ofSeconds(3));

        StepVerifier.create(mono)
                .assertNext(bookOrder -> Assertions.assertNotNull(bookOrder.getAuthor()))
                .expectComplete()
                .verify(Duration.ofSeconds(4));
    }
}
