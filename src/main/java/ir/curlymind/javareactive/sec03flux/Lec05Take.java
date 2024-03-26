package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec05Take {
    public static void main(String[] args) {
        Flux
                .create(fluxSink -> {
                    String country;
                    do {
                        country = Utils.faker().country().name();
                        System.out.println("emitting: " + country);
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("Iran (Islamic Republic of)") && !fluxSink.isCancelled());
                })
                .take(3)
                .subscribe(Utils.subscriber());
    }
}
