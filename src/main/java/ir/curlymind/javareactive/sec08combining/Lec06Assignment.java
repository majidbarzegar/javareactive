package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Assignment {
    public static void main(String[] args) {
        final int carPrice = 10000;
        Flux.combineLatest(
                        monthStream(),
                        demandStream(),
                        (month, demand) -> (carPrice - (100 * month)) * demand
                )
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);

    }

    public static Flux<Long> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    public static Flux<Double> demandStream() {
        return Flux
                .interval(Duration.ofSeconds(3))
                .map(i -> Utils.faker().random().nextInt(80, 120) / 100d)
                .startWith(1d);
    }
}
