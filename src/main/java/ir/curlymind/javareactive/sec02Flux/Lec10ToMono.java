package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec10ToMono {
    public static void main(String[] args) {
        Flux<Integer> fluxJust = Flux.just(1, 2, 3, 4, 5);

        Mono.from(fluxJust).subscribe(Utils.subscriber("mono"));

        fluxJust.next().subscribe(Utils.subscriber("flux"));
    }
}
