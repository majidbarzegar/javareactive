package ir.curlymind.javareactive.sec06threading;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofSeconds(5)) // user Schedulers.parallel() by default
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(5);
    }
}
