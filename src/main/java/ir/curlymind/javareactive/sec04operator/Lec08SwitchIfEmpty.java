package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec08SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fluxFallBack())
                .subscribe(Utils.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fluxFallBack() {
        return Flux.range(1000, 3);
    }

}
