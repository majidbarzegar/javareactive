package ir.curlymind.javareactive.sec06threading;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux
                .create(fluxSink -> {
                    printCurrentThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printCurrentThreadName("onNext " + i));

        Runnable runnable = () -> flux.subscribe(i -> printCurrentThreadName("subscribe " + i));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Utils.sleepSeconds(5);
    }

    private static void printCurrentThreadName(String message) {
        System.out.println(message + "\t\t Thread:" + Thread.currentThread().getName());
    }
}
