package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08Interval {
    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .map(i -> Utils.faker().name().fullName())
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(5);
    }
}
