package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec08State {
    public static void main(String[] args) {
        Flux
                .generate(
                        () -> 1,
                        (counter, sink) -> {
                            String country = Utils.faker().country().name();
                            sink.next(country);
                            if (counter > 3 || country.equalsIgnoreCase("Iran (Islamic Republic of)")) {
                                sink.complete();
                            }
                            return counter + 1;
                        },
                        System.out::println
                )
                .subscribe(Utils.subscriber());

    }
}
