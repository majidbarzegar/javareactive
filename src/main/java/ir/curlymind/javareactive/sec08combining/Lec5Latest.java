package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec5Latest {
    public static void main(String[] args) {
        Flux
                .combineLatest(getString(), getNumber(), (s, i) -> s + i)
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(15);
    }

    public static Flux<String> getString() {
        return Flux
                .just("A", "B", "C", "D")
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> getNumber() {
        return Flux
                .just(1, 2, 3)
                .delayElements(Duration.ofSeconds(1));
    }
}
