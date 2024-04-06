package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {

        Flux.merge(
                Qatar.getFlights(),
                America.getFlights(),
                Emirates.getFlights()
        ).subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }
}
