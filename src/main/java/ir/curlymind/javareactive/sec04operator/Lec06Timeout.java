package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Timeout {
    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fluxFallBack())
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(20);
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(3));
    }

    private static Flux<Integer> fluxFallBack() {
        return Flux.range(1000, 10);
    }

}
