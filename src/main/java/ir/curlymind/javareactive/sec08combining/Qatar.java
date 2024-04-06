package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Qatar {
    public static Flux<String> getFlights() {
        return Flux
                .range(1, Utils.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Qatar " + Utils.faker().random().nextInt(100, 999))
                .filter(i -> Utils.faker().random().nextBoolean());
    }
}
