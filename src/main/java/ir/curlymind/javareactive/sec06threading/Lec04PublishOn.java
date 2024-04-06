package ir.curlymind.javareactive.sec06threading;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {
    public static void main(String[] args) {
        Flux<Object> flux = Flux
                .create(fluxSink -> {
                    printCurrentThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printCurrentThreadName("onNext publish" + i));

        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> printCurrentThreadName("onNext subscribe" + i))
                .publishOn(Schedulers.parallel())
                .subscribe(i -> printCurrentThreadName("subscribe " + i));

        Utils.sleepSeconds(5);
    }

    private static void printCurrentThreadName(String message) {
        System.out.println(message + "\t\t Thread:" + Thread.currentThread().getName());
    }
}
