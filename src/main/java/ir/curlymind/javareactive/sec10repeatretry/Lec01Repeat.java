package ir.curlymind.javareactive.sec10repeatretry;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec01Repeat {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
//                .repeat(2) repeat 2 more
                .repeat(() -> atomicInteger.get() < 14)
                .subscribe(Utils.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux
                .range(1, 3)
                .doOnSubscribe(s -> System.out.println("--Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(integer -> atomicInteger.getAndIncrement());
    }
}
