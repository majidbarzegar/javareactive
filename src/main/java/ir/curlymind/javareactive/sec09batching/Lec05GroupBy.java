package ir.curlymind.javareactive.sec09batching;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05GroupBy {
    public static void main(String[] args) {

        Flux
                .range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2)
                .subscribe(groupedFlux -> process(groupedFlux, groupedFlux.key()));

        Utils.sleepSeconds(60);
    }

    private static void process(Flux<Integer> flux, int key) {
        System.out.println("Called");
        flux.subscribe(i -> System.out.println("key: " + key + " item: " + i));
    }


}
