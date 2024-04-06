package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec02ConcatWith {
    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a", "b");
        Flux<Object> flux2 = Flux.error(new RuntimeException("oops"));
        Flux<String> flux3 = Flux.just("c", "d", "e");

        Flux
                .concat(flux1, flux2, flux3)
                .subscribe(Utils.subscriber());

        System.out.println("--------------------------------");

        Flux
                .concatDelayError(flux1, flux2, flux3)
                .subscribe(Utils.subscriber());

    }
}
