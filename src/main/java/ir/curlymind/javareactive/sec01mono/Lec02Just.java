package ir.curlymind.javareactive.sec01mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;

public class Lec02Just {
    public static void main(String[] args) {
        Mono<Integer> monoJust = Mono.just(1);

        System.out.println(monoJust);

        monoJust.subscribe(Utils.subscriber());
    }
}
