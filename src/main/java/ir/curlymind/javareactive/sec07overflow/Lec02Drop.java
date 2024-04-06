package ir.curlymind.javareactive.sec07overflow;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec02Drop {
    public static void main(String[] args) {

        // 75% -> 12
        System.setProperty("reactor.bufferSize.small", "16"); // default Queues.SMALL_BUFFER_SIZE = 256

        List<Object> list = new ArrayList<>();

        Flux
                .create(fluxSink -> {
                    for (int i = 1; i <= 200; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                        Utils.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Utils.sleepMillis(10))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
        System.out.println(list);
    }
}
