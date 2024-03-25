package ir.curlymind.javareactive.mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07Future {
    public static void main(String[] args) {
        Mono<String> monoFuture = Mono.fromFuture(Lec07Future::getName);
        monoFuture.subscribe(Utils.subscriber());
        Utils.sleepSeconds(1);
    }

    public static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Utils.faker().name().fullName());
    }


}
