package ir.curlymind.javareactive.sec01mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;


public class Lec08Runnable {
    public static void main(String[] args) {
        System.out.println("Operation start.");
        Mono<Object> monoRunnable = Mono.fromRunnable(timeConsumingProcess());
        monoRunnable.subscribe(Utils.subscriber());

    }

    public static Runnable timeConsumingProcess() {
        return () -> {
            Utils.sleepSeconds(3);
            System.out.println("Operation completed.");
        };
    }


}
