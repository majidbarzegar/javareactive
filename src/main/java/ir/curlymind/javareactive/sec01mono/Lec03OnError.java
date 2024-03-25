package ir.curlymind.javareactive.sec01mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;

public class Lec03OnError {
    public static void main(String[] args) {
        Mono<Integer> monoJust = Mono.just(1)
                .map(i -> i/0);

        monoJust.subscribe(Utils.subscriber());
    }
}
