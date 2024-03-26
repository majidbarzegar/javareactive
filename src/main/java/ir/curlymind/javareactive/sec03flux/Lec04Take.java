package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec04Take {
    public static void main(String[] args) {
        Flux
                .range(1, 10)
                .log()
                .take(3) // cancel the subscription
                .log()
                .subscribe(Utils.subscriber());
    }
}
