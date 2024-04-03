package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec05OnError {
    public static void main(String[] args) {
        Flux
                .range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
//                .onErrorReturn(-1)
//                .onErrorResume(e -> monoFallBack())
//                .onErrorResume(e -> fluxFallBack())
                .onErrorContinue((error, o) -> {
                    System.out.println("Error (" + error.getMessage() + ") in object: " + o);
                })
                .subscribe(Utils.subscriber());
    }

    private static Mono<Integer> monoFallBack() {
        return Mono.fromSupplier(() -> Utils.faker().random().nextInt(100, 200));
    }

    private static Flux<Integer> fluxFallBack() {
        return Flux.range(1, 10);
    }
}
