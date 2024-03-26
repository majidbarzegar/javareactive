package ir.curlymind.javareactive.sec02flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FromMono {
    public static void main(String[] args) {
        Mono<Integer> monoJust = Mono.just(1);
        Flux.from(monoJust).subscribe(Utils.subscriber());
    }
}
