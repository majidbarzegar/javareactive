package ir.curlymind.javareactive.sec07overflow;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03Latest {
    public static void main(String[] args) {

        // 75% -> 12
        System.setProperty("reactor.bufferSize.small", "16"); // default Queues.SMALL_BUFFER_SIZE = 256

        Flux
                .create(fluxSink -> {
                    for (int i = 1; i <= 200; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                        Utils.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Utils.sleepMillis(10))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
    }
}
