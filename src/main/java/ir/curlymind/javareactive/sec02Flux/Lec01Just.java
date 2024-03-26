package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec01Just {
    public static void main(String[] args) {

        Flux<Integer> fluxJust = Flux.just(1, 2, 3, 4, 5);
        fluxJust.subscribe(Utils.subscriber());

    }
}
