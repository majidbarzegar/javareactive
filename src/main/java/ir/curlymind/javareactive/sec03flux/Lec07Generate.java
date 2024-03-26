package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec07Generate {
    public static void main(String[] args) {
        Flux
                .generate(synchronousSink -> {
                    String country = Utils.faker().country().name();
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("Iran (Islamic Republic of)")) {
                        synchronousSink.error(new RuntimeException("WOW Iran"));
                    }
                })
                .subscribe(Utils.subscriber());
    }
}
