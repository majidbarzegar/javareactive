package ir.curlymind.javareactive.sec02flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {
    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);

        return Flux.interval(Duration.ofSeconds(1))
                .map(i ->
                        atomicInteger.getAndAccumulate(
                                Utils.faker().random().nextInt(-2, +2),
                                Integer::sum
                        )
                );
    }
}
