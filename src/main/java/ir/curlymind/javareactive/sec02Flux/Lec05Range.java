package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec05Range {
    public static void main(String[] args) {

        Flux<Integer> fluxRange = Flux.range(9, 5);
        fluxRange.subscribe(Utils.subscriber());

        Flux<Integer> fluxNameRange = Flux.range(1, 5);
        fluxNameRange
                .log()
                .map(i -> Utils.faker().name().fullName())
                .log()
                .subscribe(Utils.subscriber());

    }
}
