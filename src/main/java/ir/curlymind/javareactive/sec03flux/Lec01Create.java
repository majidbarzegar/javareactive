package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec01Create {
    public static void main(String[] args) {
        Flux
                .create(fluxSink -> {
                    fluxSink.next(1);
                    fluxSink.next(2);
                    fluxSink.next(3);
                    fluxSink.error(new RuntimeException("not found"));
                    fluxSink.complete();
                })
                .subscribe(Utils.subscriber());

        Flux
                .create(fluxSink -> {
                    String country;
                    do {
                        country = Utils.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("Iran (Islamic Republic of)"));
                })
                .subscribe(Utils.subscriber());

    }
}
