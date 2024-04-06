package ir.curlymind.javareactive.sec07overflow;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec01Demo {
    public static void main(String[] args) {
        Flux
                .create(fluxSink -> {
                    for (int i = 1; i <= 500; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                    }
                    fluxSink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Utils.sleepMillis(10))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }
}
