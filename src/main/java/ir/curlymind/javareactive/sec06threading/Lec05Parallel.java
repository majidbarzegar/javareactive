package ir.curlymind.javareactive.sec06threading;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec05Parallel {
    public static void main(String[] args) {
        Flux
                .range(1, 10)
//                .parallel()
                .parallel(5)
                .runOn(Schedulers.parallel())
                .doOnNext(i -> printCurrentThreadName("nxt " + i))
//                .sequential() // change from ParallelFlux to Flux
                .subscribe(i -> printCurrentThreadName("sub " + i));

        List<Integer> list = new ArrayList<>(); // ArrayList is not thread safe
        Flux
                .range(1, 1000)
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(list::add);
        System.out.println(list.size());

        Utils.sleepSeconds(5);
    }

    private static void printCurrentThreadName(String message) {
        System.out.println(message + "\t\t Thread:" + Thread.currentThread().getName());
    }
}
