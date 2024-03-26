package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec06Generate {
    public static void main(String[] args) {

        Flux
                .generate(synchronousSink -> {
                    System.out.println("emitting");
                    synchronousSink.next(Utils.faker().country().capital());
                    /*synchronousSink.complete();
                    synchronousSink.error(new RuntimeException("oops"));*/
                })
                .take(3)
                .subscribe(Utils.subscriber());
    }
}
