package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {
        Flux
                .range(1, 10)
                .handle((i, sink) -> sink.next(i + " " + Utils.faker().country().name())) // filter + map
                .subscribe(Utils.subscriber());

        Flux
                .generate(sink -> sink.next(Utils.faker().country().name()))
                .map(Object::toString)
                .handle((country, sink) -> {
                    sink.next(country);
                    if (country.equalsIgnoreCase("Iran (Islamic Republic of)")) {
                        sink.complete();
                    }
                })
                .subscribe(Utils.subscriber());
    }
}
