package ir.curlymind.javareactive.sec06threading;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux
                .create(fluxSink -> {
                    printCurrentThreadName("create");
                    fluxSink.next(1);
                })
                .subscribeOn(Schedulers.newParallel("newParallel"))
                .doOnNext(i -> printCurrentThreadName("onNext " + i));

        Runnable runnable = () -> flux
                .doFirst(() -> printCurrentThreadName("doFirst 2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printCurrentThreadName("doFirst 1"))
                .subscribe(i -> printCurrentThreadName("subscribe " + i));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Utils.sleepSeconds(5);
    }

    private static void printCurrentThreadName(String message) {
        System.out.println(message + "\t\t Thread:" + Thread.currentThread().getName());
    }
}
