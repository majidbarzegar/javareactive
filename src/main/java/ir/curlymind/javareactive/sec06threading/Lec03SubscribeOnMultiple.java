package ir.curlymind.javareactive.sec06threading;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03SubscribeOnMultiple {
    public static void main(String[] args) {
        Flux<Object> flux = Flux
                .create(fluxSink -> {
                    printCurrentThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Utils.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printCurrentThreadName("onNext " + i));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(i -> printCurrentThreadName("subscribe " + i));

        flux
                .subscribeOn(Schedulers.parallel())
                .subscribe(i -> printCurrentThreadName("subscribe " + i));


        Utils.sleepSeconds(5);
    }

    private static void printCurrentThreadName(String message) {
        System.out.println(message + "\t\t Thread:" + Thread.currentThread().getName());
    }
}
