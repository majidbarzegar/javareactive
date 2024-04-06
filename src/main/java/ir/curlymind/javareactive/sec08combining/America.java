package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class America {
    public static Flux<String> getFlights() {
        return Flux
                .range(1, Utils.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "America " + Utils.faker().random().nextInt(100, 999))
                .filter(i -> Utils.faker().random().nextBoolean());
    }
}
